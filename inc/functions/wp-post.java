/**
 * WordPress文章推送
 * @Author：鼠子(ShuShuicu)
 * @Link: https://blog.miomoe.cn/
 */
public String get(String url) {
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try {
        URL urlObj = new URL(url);
        HttpURLConnection uc = (HttpURLConnection) urlObj.openConnection();
        uc.setConnectTimeout(10000);
        uc.setReadTimeout(10000);
        isr = new InputStreamReader(uc.getInputStream(), "utf-8");
        BufferedReader reader = new BufferedReader(isr); // 缓冲
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line).append("\n");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (isr != null) {
                isr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    if (buffer.length() == 0) return buffer.toString();
    buffer.delete(buffer.length() - 1, buffer.length());
    return buffer.toString();
}

public String parseJson(String json) {
    StringBuilder result = new StringBuilder();
    try {
        JSONArray posts = new JSONArray(json);
        if (posts.length() == 0) {  // 检查是否有返回的文章
            return "没有找到相关的文章。\n---------\n====鼠子Java====";
        }
        int limit = Math.min(posts.length(), 10); // 限制文章数量为10
        for (int i = 0; i < limit; i++) {
            JSONObject post = posts.getJSONObject(i);
            String title = post.getJSONObject("title").getString("rendered"); // 获取标题的渲染内容

            // 手动替换常见的 HTML 实体
            title = title.replaceAll("&#8211;", "-"); // 替换 &#8211; 为 -
            title = title.replaceAll("&#8230;", "..."); // 替换 &#8230; 为 ...
            title = title.replaceAll("<[^>]*>", ""); // 正则表达式替换所有 HTML 标签

            String link = post.getString("link");   // 获取文章链接
            result.append("标题: ").append(title).append("\n链接: ").append(link).append("\n------\n");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: 数据解析失败。";
    }
    return result.toString();
}

AddItem("WordPress文章推送/开关", "wpPostOpen");

public void wpPostOpen(String group) {
    if ("1".equals(getString(group, "是否开启"))) {
        putString(group, "是否开启", null);
        Toast("文章推送关闭");
    } else {
        putString(group, "是否开启", "1");
        Toast("文章推送开启");
    }
}

public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.msg.peerUin + "";
    String qun = msg.GroupUin;
    String groupId = msg.GroupUin;
    String content = msg.MessageContent;

    if ("1".equals(getString(qun, "是否开启"))) {
        // 处理 #搜索文章 指令
        if (content.startsWith("#搜索文章")) {
            String searchQuery = content.substring(5).trim();  // 修正指令截取
            String url = get("https://www.zbtool.cn/wp-json/wp/v2/posts?search=" + searchQuery);
            String parsedResult = parseJson(url); // 解析JSON并返回结果
            if (msg.IsGroup) {
                sendMsg(qun, "", parsedResult);
            } else {
                sendMsg("", qq, parsedResult);
            }
        }

        // 处理 #最新文章 指令
        if (content.startsWith("#最新文章")) {
            String url = get("https://www.zbtool.cn/wp-json/wp/v2/posts"); // 获取最新文章
            String parsedResult = parseJson(url); // 解析JSON并返回结果
            if (msg.IsGroup) {
                sendMsg(qun, "", parsedResult);
            } else {
                sendMsg("", qq, parsedResult);
            }
        }

        if (text.equals("#文章推送")) {
            String reply = "====文章推送====\n -#最新文章\n -#搜索文章+关键词\n====鼠子Java====";

            if (msg.IsGroup)
            {
                sendMsg(qun,"",reply);
            }
            else
            {
                sendMsg("",qq,reply);
            }
        }

    }
}
