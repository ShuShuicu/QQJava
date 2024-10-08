/**
 * AI回复
 */
public String get(String url)
{
    StringBuffer buffer = new StringBuffer();
    InputStreamReader isr = null;
    try {
        URL urlObj = new URL(url);
        HttpURLConnection uc = urlObj.openConnection();
        uc.setConnectTimeout(10000);
        uc.setReadTimeout(10000);
        isr = new InputStreamReader(uc.getInputStream(), "utf-8");
        BufferedReader reader = new BufferedReader(isr); //缓冲
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line + "\n");
        }
    } catch (Exception e) {
        if (null != isr) {
            isr.close();
        }
        e.printStackTrace();
    } finally {
        try {
            if (null != isr) {
                isr.close();
            }
        } catch (IOException e) {
            if (null != isr) {
                isr.close();
            }
            e.printStackTrace();
        }
    }
    if(buffer.length()==0)return buffer.toString();
    buffer.delete(buffer.length()-1,buffer.length());
    return buffer.toString();
}
AddItem("AI回复/开关","aiOpen");
public void aiOpen(String group) {
    if ("1".equals(getString(group, "是否开启"))) {
        putString(group, "是否开启", null);
        Toast("AI关闭");
    } else {
        putString(group, "是否开启", "1");
        Toast("AI开启");
    }
}
public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.msg.peerUin+"";
    String qun = msg.GroupUin;
    String groupId = msg.GroupUin;
    String content = msg.MessageContent;


    if("1".equals(getString(qun, "是否开启"))){


        if (content.startsWith("#AI")) {
            String url = get("http://api.qingyunke.com/api.php?key=free&appid=0&msg="+ content.substring(4).trim());
            if (msg.IsGroup) {
                sendMsg(qun,"",url);
            }else{
                sendMsg("",qq,url2);
            }
        }


    }
    if("1".equals(getString(qq,"是否开启"))) {
        if(msg.UserUin.equals(MyUin))                       return;
        if (content.startsWith("")) {
            String url = get("http://api.qingyunke.com/api.php?key=free&appid=0&msg="+ content.substring(1).trim());
            if (msg.IsGroup) {
                sendMsg(qun,"",url2);
            }else{
                sendMsg("",qq,url);
            }
        }
    }
}