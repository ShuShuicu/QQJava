/**
 * 菜单
 */
public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.UserUin;
    String qun = msg.GroupUin;

    if (text.equals("#菜单") && qq.equals(MyUin)) {

        String reply = "====鼠子Java====" +
                "\n---------\n" +
                "请发送关键词" +
                "\n---------\n" +
                " - #赞我" +
                "\n"+
                "(自动点赞20下)" +
                "\n"+
                " - #AI+问题" +
                "\n"+
                "(使用AI小模型回复信息)" +
                "\n"+
                " - #艾特表情" +
                "\n"+
                "(关键词+@QQ返回图片)" +
                "\n"+
                " - #文章推送" +
                "\n"+
                "(推送WP站点文章)" +
                "\n---------\n" +
                "注：功能未开启则不会返回内容" +
                "\n---------\n" +
                "====感谢使用====";

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