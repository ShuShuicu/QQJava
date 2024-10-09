/**
 * 鼠子Java核心文件
 * @Author：鼠子(ShuShuicu)
 * @Link: https://blog.miomoe.cn/
 */
import android.os.Environment;
import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.text.StringEscapeUtils;

sendLike("1778273540", 20);

// 引入脚本功能
load(AppPath + "/inc/menu.java");
load(AppPath + "/inc/functions/at.java");
load(AppPath + "/inc/functions/ai.java");
load(AppPath + "/inc/functions/admin.java");
load(AppPath + "/inc/functions/good.java");
load(AppPath + "/inc/functions/wp-post.java");

public String location(String urlString) {
    URL url = new URL(urlString);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setInstanceFollowRedirects(false);
    connection.connect();
    String PicUrl= connection.getHeaderField("Location");
    return PicUrl;
}

//获取今日日期 返回为2024-10-08
public String getTodayDate() {
    Date date=new Date();//此时date为当前的时间
    SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd");//设置当前时间的格式，为年-月-日
    return dateFormat.format(date);
}

Toast("发送 \"#菜单\" 查看使用说明");

String like = "1778273540";
if (getBoolean("like_"+getTodayDate(),like,false)) return;
putBoolean("like_"+getTodayDate(),like,true);
sendLike(like,20);