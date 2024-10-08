/**
 * 艾特表情
 */
AddItem("艾特表情/开关","atOpen");
public void atOpen(String group) {
    if ("1".equals(getString(group, "是否开启"))) {
        putString(group, "是否开启", null);
        Toast("艾特表情关闭");
    } else {
        putString(group, "是否开启", "1");
        Toast("艾特表情开启");
    }
}

public void onMsg(Object msg) {
    String text = msg.MessageContent;
    String qq = msg.msg.peerUin+"";
    String qun = msg.GroupUin;
    String groupId = msg.GroupUin;
    String content = msg.MessageContent;
    //群未开启
    if(!"1".equals(getString(qun, "是否开启")) &&!"1".equals(getString(qq,"是否开启"))) return;

    if (content.startsWith("咬@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_suck/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_suck/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("膜拜@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_worship/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_worship/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("揉@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_petpet/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_petpet/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("想看@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_thsee/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_thsee/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("捣@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_pound/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_pound/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("炸虾@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_yu/api.php?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_yu/api.php?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("玩@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_play/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_play/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("摸摸@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.lolimi.cn/API/face_petpet/?QQ="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.lolimi.cn/API/face_petpet/?QQ="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("滚出@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/gun.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/gun.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("咸鱼@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/face_yu.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/face_yu.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("地图@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/zgdt.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/zgdt.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("单身@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/dsgz.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/dsgz.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("吃@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/face_bite.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/face_bite.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("亲@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/face_kiss.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/face_kiss.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("抱@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/bao.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/bao.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("羡慕@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/xianmu.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/xianmu.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("点赞@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/zan.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/zan.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("爬@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/pa.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/pa.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("举@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/ju.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/ju.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("可莉@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/chi.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/chi.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("赞@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://shanhe.kim/api/qq/zan2.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://shanhe.kim/api/qq/zan2.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("拍@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/weixie.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/weixie.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("警察@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/Policebadge.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/Policebadge.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("黑头@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/ImageBlackWhiteMelt.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/ImageBlackWhiteMelt.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("质量@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/gzl.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/gzl.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("舔@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://shanhe.kim/api/qq/tian.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://shanhe.kim/api/qq/tian.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("黑子@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/cxk.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/cxk.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("感动@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/face_touch.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/face_touch.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("摸头@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://shanhe.kim/api/qq/mo.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://shanhe.kim/api/qq/mo.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("拿@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "http://api.bi71t5.cn/api/ju_1.php?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "http://api.bi71t5.cn/api/ju_1.php?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("客服@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.mhimg.cn/api/biaoqingbao_kf/?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.mhimg.cn/api/biaoqingbao_kf/?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (content.startsWith("哈@")) {
        if (msg.IsGroup) {
            String atqq = msg.mAtList.get(0);
            String url = "https://api.mhimg.cn/api/biaoqingbao_ha/?qq="+ atqq;
            sendMsg(qun,"","[PicUrl=" +        url + "]");
        }else{
            String url2 = "https://api.mhimg.cn/api/biaoqingbao_ha/?qq="+ qq;
            sendMsg("",qq,"[PicUrl=" +         url2 + "]");
        }
    }
    if (text.equals("#艾特表情")) {
        String reply = "====头像表情====\n揉@QQ 捣@QQ\n拍@QQ 玩@QQ\n亲@QQ 舔@QQ\n举@QQ 爬@QQ\n吃@QQ 咬@QQ\n抱@QQ 赞@QQ\n拿@QQ 哈@QQ\n====二字表情====\n膜拜@QQ 想看@QQ\n炸虾@QQ 摸摸@QQ\n滚出@QQ 咸鱼@QQ\n单身@QQ 地图@QQ\n羡慕@QQ 点赞@QQ\n可莉@QQ 警察@QQ\n黑头@QQ 质量@QQ\n黑子@QQ 感动@QQ\n摸头@QQ 客服@QQ\n====感谢使用====";

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