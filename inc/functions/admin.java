/**
 * 群管功能
 * @Author：鼠子(ShuShuicu)
 * @Link: https://blog.miomoe.cn/
 */
public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.UserUin;
    String qun = msg.GroupUin;


    //正则表达式+解析时间格式来进行禁言 可以响应"禁言@xxx 1天"这样的消息
    //下面我写了三个匹配条件 并用&&相连 表示他们需要全部匹配才会发生
    if(msg.IsSend //是自己发送
            && msg.MessageContent.matches("禁言 ?@[\\s\\S]+[0-9]+(天|分|时|小时|分钟|秒)") //是"禁言@xxx 1天"这样的消息
            && msg.mAtList.size()>=1//艾特列表中 艾特人数至少有1个
    ) {
        int banTime = parseTimeBymessage(msg);
        if(banTime>=60*60*24*30+1) {
            sendMsg(msg.GroupUin,"","请控制在30天以内");
            return;
        } else {
            for(String atUin : msg.mAtList) {
                Forbidden(msg.GroupUin,atUin,banTime);
            }
        }

    }


}

//将"禁言@xxx 1天"解析成 84600这样的秒格式
public int parseTimeBymessage(Object msg){
    int timeStartIndex = msg.MessageContent.lastIndexOf(" ");
    String date = msg.MessageContent.substring(timeStartIndex +1);
    date = date.trim();
    String t="";
    if(date != null && !"".equals(date)){
        for(int i=0;i<date.length();i++){
            if(date.charAt(i)>=48 && date.charAt(i)<=57){
                t +=date.charAt(i);
            }
        }
    }
    int time=Integer.parseInt(t);
    if(date.contains("天")){
        return time*60*60*24;
    }
    else if(date.contains("时") || date.contains("小时") ){
        return 60*60*time;
    }
    else if(date.contains("分") || date.contains("分钟") ){
        return 60*time;
    }
    return time;
}