/**
 * 赞我功能
 * @Author：鼠子(ShuShuicu)
 * @Link: https://blog.miomoe.cn/
 */

String Text1 = "已点赞20下！"; // 无声点赞时的默认回复
String Text2 = "赞过了憨憨！"; // 首次点赞时的回复
String Pic = ""; // 首次点赞时回复的图片链接
String Pic2 = ""; // 重复点赞时的图片链接
String PTT1 = ""; // 首次点赞的语音路径
String PTT2 = ""; // 重复点赞的语音路径

AddItem("赞我/开关", "goodOpen");

public void goodOpen(String group) {
    if ("1".equals(getString(group, "是否开启"))) {
        putString(group, "是否开启", null);
        Toast("点赞关闭");
    } else {
        putString(group, "是否开启", "1");
        Toast("点赞开启");
    }
}

public void onMsg(Object msg) {
    String qun = msg.GroupUin;

    // 检查点赞功能是否开启
    if ("1".equals(getString(qun, "是否开启"))) {
        if (msg.MessageContent.startsWith("#赞我")) {
            Calendar cl = Calendar.getInstance();
            String day = cl.get(Calendar.YEAR) + "-" + cl.get(Calendar.DAY_OF_YEAR); // 获取当前日期

            // 检查用户最后点赞的日期
            if (day.equals(getString("QQ" + msg.UserUin, "最后点赞"))) {
                // 重复点赞的处理
                if (PTT2 != null && !PTT2.equals("")) {
                    sendVoice(qun, "", PTT2); // 发送重复点赞的语音
                }
                String send = Text2 + ((Pic2 == null || Pic2.equals("")) ? "" : "[PicUrl=" + Pic2 + "]");
                if (send != null && !send.equals("")) {
                    sendReply(msg.GroupUin, msg, send); // 回复消息
                }
            } else {
                // 首次点赞的处理
                sendLike(msg.UserUin, 20); // 调用点赞功能
                if (PTT1 != null && !PTT1.equals("")) {
                    sendVoice(qun, "", PTT1); // 发送首次点赞的语音
                }
                String send = Text1 + ((Pic == null || Pic.equals("")) ? "" : "[PicUrl=" + Pic + "]");
                if (send != null && !send.equals("")) {
                    sendReply(msg.GroupUin, msg, send); // 回复消息
                }
                putString("QQ" + msg.UserUin, "最后点赞", day); // 更新用户最后点赞日期
            }
        }
    }
}
