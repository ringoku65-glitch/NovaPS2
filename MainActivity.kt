package com.salati.app
import android.app.*; import android.os.*; import android.content.pm.PackageManager; import android.graphics.Color; import android.view.Gravity; import android.widget.*; import java.text.SimpleDateFormat; import java.util.*
class MainActivity:Activity(){
 private val prayers=listOf("الفجر" to "05:10","الشروق" to "06:35","الظهر" to "12:45","العصر" to "16:10","المغرب" to "19:05","العشاء" to "20:30")
 override fun onCreate(b:Bundle?){super.onCreate(b)
  if(Build.VERSION.SDK_INT>=33&&checkSelfPermission("android.permission.POST_NOTIFICATIONS")!=PackageManager.PERMISSION_GRANTED)requestPermissions(arrayOf("android.permission.POST_NOTIFICATIONS"),10)
  val r=LinearLayout(this);r.orientation=LinearLayout.VERTICAL;r.setPadding(24,30,24,20);r.setBackgroundColor(Color.rgb(7,26,20))
  fun t(s:String,n:Float)=TextView(this).apply{text=s;textSize=n;setTextColor(Color.WHITE);gravity=Gravity.CENTER}
  r.addView(t("🕌 صلاتي",30f),LinearLayout.LayoutParams(-1,70));r.addView(t(SimpleDateFormat("EEEE، d MMMM yyyy",Locale("ar")).format(Date()),16f))
  r.addView(t("الصلاة القادمة\nالعصر — 16:10",23f),LinearLayout.LayoutParams(-1,120))
  prayers.forEach{(n,x)->val v=t("   $n                              $x",19f);v.gravity=Gravity.CENTER_VERTICAL;v.setPadding(12,0,0,0);v.setBackgroundColor(Color.rgb(16,52,42));val p=LinearLayout.LayoutParams(-1,62);p.setMargins(0,4,0,4);r.addView(v,p)}
  r.addView(t("📍 الجزائر   •   🔔 التذكير مفعّل",15f),LinearLayout.LayoutParams(-1,80));setContentView(r)
 }}
