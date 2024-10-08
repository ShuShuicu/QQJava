/**
 * 赞我功能
 */

//下面都为空不会发送任何内容(无声点赞)
    String Text1="已点赞20下=。=";
//首次点赞时回复的文本，空无字
        String Text2 = "赞过了憨憨！";
//重复点赞时回复的文字。空无字

        String Pic = "";
//首次点赞时回复的图片链接或者本地路径。空无图片(不需要加上[PicUrl=])
        String Pic2 = "";
//重复点赞时回复的图片链接或者本地路径。空无图片(不需要加上[PicUrl=])

        String PTT1 = "";
//首次点赞的语音路径。空不发，只能本地语音路径
        String PTT2 = "";
//重复点赞发的语音路径。空不发，只能本地语音路径

AddItem("赞我/开关","goodOpen");
public void goodOpen(String group) {
    if ("1".equals(getString(group, "是否开启"))) {
        putString(group, "是否开启", null);
        Toast("点赞关闭");
    } else {
        putString(group, "是否开启", "1");
        Toast("点赞开启");
    }
}

public void onMsg(Object msg)
{
    String qun=msg.GroupUin;
    if("1".equals(getString(qun,"是否开启")))
    {
        if(msg.MessageContent.startsWith("#赞我"))
        {
            Calendar cl = Calendar.getInstance();
            String Day =cl.get(Calendar.YEAR)+"-"+ cl.get(Calendar.DAY_OF_YEAR);
            //Toast(Day);
            if(Day.equals(getString("QQ"+msg.UserUin,"最后点赞")))
            {
                if(PTT2!=null&&!PTT2.equals("")) sendVoice(qun,"",PTT2);
                String send=Text2+((Pic2.equals("")||Pic2==null) ?"" : "[PicUrl="+Pic2+"]");
                if(send!=null&&!send.equals("")) sendReply(msg.GroupUin,msg,send);
            }else
            {
                sendLike(msg.UserUin,20);
                if(PTT1!=null&&!PTT1.equals("")) sendVoice(qun,"",PTT1);
                String send=Text1+((Pic.equals("")||Pic==null) ?"" : "[PicUrl="+Pic+"]");
                if(send!=null&&!send.equals("")) sendReply(msg.GroupUin,msg,send);
                putString("QQ"+msg.UserUin,"最后点赞",Day);
            }
        }
    }
}