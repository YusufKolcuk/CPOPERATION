package cp.clinicplast.asus.operationcp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Operation extends AppCompatActivity {
    public static CheckBox alin,kulak,burun,gozkapagi,yuzgerme,vaser,karin,kol,memedik,memebuy,memekuc,jineko,labio,vajina,sac,scarlet,hydra,yuzdolgu;
    int alin2,kulak2,burun2,gozkapagi2,yuzgerme2,vaser2,karin2,kol2,memedik2,memebuy2,memekuc2,jineko2,labio2,vajina2,sac2,scarlet2,hydra2,yuzdolgu2;
    ArrayList<Integer> dizi=new ArrayList();
    Button fiyatHesap;
    String turkishlira,usd;
    float amel1,amel2,amel3,amel4,amel5,amel6,amel7,amel8,amel9,amel10,amel11,amel12,amel13,amel14,amel15,amel16,amel17,amel18;
    static float opFiyat,trFiyat,usdFiyat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cp.clinicplast.asus.operationcp.R.layout.activity_operation);
        alin=findViewById(cp.clinicplast.asus.operationcp.R.id.c1);
        kulak=findViewById(cp.clinicplast.asus.operationcp.R.id.c2);
        burun=findViewById(cp.clinicplast.asus.operationcp.R.id.c3);
        gozkapagi=findViewById(cp.clinicplast.asus.operationcp.R.id.c4);
        yuzgerme=findViewById(cp.clinicplast.asus.operationcp.R.id.c5);
        vaser=findViewById(cp.clinicplast.asus.operationcp.R.id.c6);
        karin=findViewById(cp.clinicplast.asus.operationcp.R.id.c7);
        kol=findViewById(cp.clinicplast.asus.operationcp.R.id.c8);
        memedik=findViewById(cp.clinicplast.asus.operationcp.R.id.c9);
        memebuy=findViewById(cp.clinicplast.asus.operationcp.R.id.c10);
        memekuc=findViewById(cp.clinicplast.asus.operationcp.R.id.c11);
        jineko=findViewById(cp.clinicplast.asus.operationcp.R.id.c12);
        labio=findViewById(cp.clinicplast.asus.operationcp.R.id.c13);
        vajina=findViewById(cp.clinicplast.asus.operationcp.R.id.c14);
        sac=findViewById(cp.clinicplast.asus.operationcp.R.id.c15);
        scarlet=findViewById(cp.clinicplast.asus.operationcp.R.id.c16);
        hydra=findViewById(cp.clinicplast.asus.operationcp.R.id.c17);
        yuzdolgu=findViewById(cp.clinicplast.asus.operationcp.R.id.c18);
        fiyatHesap=findViewById(cp.clinicplast.asus.operationcp.R.id.fiyatHesap);



        fiyatHesap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(alin.isChecked()){
                    alin2=OperationMoney.alin;
                    dizi.add(alin2);
                }
                if(kulak.isChecked()){
                    kulak2=OperationMoney.kulak;
                    dizi.add(kulak2);
                }
                if(burun.isChecked()){
                    burun2=OperationMoney.burun;
                    dizi.add(burun2);
                }
                if(gozkapagi.isChecked()){
                    gozkapagi2=OperationMoney.gozkapagi;
                    dizi.add(gozkapagi2);
                }
                if(yuzgerme.isChecked()){
                    yuzgerme2=OperationMoney.yuzgerme;
                    dizi.add(yuzgerme2);
                }
                if(vaser.isChecked()){
                    vaser2=OperationMoney.vaser;
                    dizi.add(vaser2);
                }
                if(karin.isChecked()){
                    karin2=OperationMoney.karin;
                    dizi.add(karin2);
                }
                if(kol.isChecked()){
                    kol2=OperationMoney.kol;
                    dizi.add(kol2);
                }
                if(memedik.isChecked()){
                    memedik2=OperationMoney.memedik;
                    dizi.add(memedik2);
                }
                if(memebuy.isChecked()){
                    memebuy2=OperationMoney.memebuy;
                    dizi.add(memebuy2);
                }
                if(memekuc.isChecked()){
                    memekuc2=OperationMoney.memekuc;
                    dizi.add(memekuc2);
                }
                if(jineko.isChecked()){
                    jineko2=OperationMoney.jineko;
                    dizi.add(jineko2);
                }
                if(labio.isChecked()){
                    labio2=OperationMoney.labio;
                    dizi.add(labio2);
                }
                if(vajina.isChecked()){
                    vajina2=OperationMoney.vajina;
                    dizi.add(vajina2);
                }
                if(sac.isChecked()){
                    sac2=OperationMoney.sac;
                    dizi.add(sac2);
                }
                if(scarlet.isChecked()){
                    scarlet2=OperationMoney.scarlet;
                    dizi.add(scarlet2);
                }
                if(hydra.isChecked()){
                    hydra2=OperationMoney.hydra;
                    dizi.add(hydra2);
                }
                if(yuzdolgu.isChecked()){
                    yuzdolgu2=OperationMoney.yuzdolg;
                    dizi.add(yuzdolgu2);
                }
               // Toast.makeText(getApplicationContext(),dizi+"",Toast.LENGTH_SHORT).show();
               try{
                   hesaplama();

               }catch (NullPointerException e){

               }
                frg();
                dizi.clear();

            }
        });
    }

    public void hesaplama(){
        Log.e("muh","asdasdasd");
        getRates();
        Collections.sort(dizi,Collections.reverseOrder());
        if(dizi.size()==1){
            amel1=dizi.get(0);
            opFiyat=amel1;
        }
        else if(dizi.size()==2){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            opFiyat=(amel1*1)+(amel2*50/100);

        }
        else if(dizi.size()==3){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100);

        }
        else if(dizi.size()==4){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100);

        }
        else if(dizi.size()==5){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100);

        }
        else if(dizi.size()==6){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100);

        }
        else if(dizi.size()==7){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            amel7=dizi.get(6);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100)+(amel7*20/100);

        }
        else if(dizi.size()==8){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            amel7=dizi.get(6);
            amel8=dizi.get(7);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100)+(amel7*20/100)+(amel8*20/100);
        }
        else if(dizi.size()==9){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            amel7=dizi.get(6);
            amel8=dizi.get(7);
            amel9=dizi.get(8);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100)+(amel7*20/100)+(amel8*20/100)+(amel9*20/100);
        }
        else if(dizi.size()==10){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            amel7=dizi.get(6);
            amel8=dizi.get(7);
            amel9=dizi.get(8);
            amel10=dizi.get(9);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100)+(amel7*20/100)+(amel8*20/100)+(amel9*20/100)+(amel10*20/100);
        }
        else if(dizi.size()==11){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            amel7=dizi.get(6);
            amel8=dizi.get(7);
            amel9=dizi.get(8);
            amel10=dizi.get(9);
            amel11=dizi.get(10);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100)+(amel7*20/100)+(amel8*20/100)+(amel9*20/100)+(amel10*20/100)+(amel11*20/100);
        }
        else if(dizi.size()==12){
            amel1=dizi.get(0);
            amel2=dizi.get(1);
            amel3=dizi.get(2);
            amel4=dizi.get(3);
            amel5=dizi.get(4);
            amel6=dizi.get(5);
            amel7=dizi.get(6);
            amel8=dizi.get(7);
            amel9=dizi.get(8);
            amel10=dizi.get(9);
            amel11=dizi.get(10);
            amel12=dizi.get(11);
            opFiyat=(amel1*1)+(amel2*50/100)+(amel3*20/100)+(amel4*20/100)+(amel5*20/100)+(amel6*20/100)+(amel7*20/100)+(amel8*20/100)+(amel9*20/100)+(amel10*20/100)+(amel11*20/100)+(amel12*20/100);
        }

        else
        {
            Toast.makeText(getApplicationContext(),"12 OPERASYONDAN FAZLA SEÇİLEMEZ",Toast.LENGTH_LONG).show();
        }
        trFiyat=opFiyat*(Float.parseFloat(turkishlira));
        usdFiyat=opFiyat*(Float.parseFloat(usd));
        Log.e("kolcuk",trFiyat+"**"+opFiyat+"**"+(Float.parseFloat(turkishlira)));
        Log.e("kolcuk2",opFiyat+"**");


    }
    public void frg(){
        fragment nesne=new fragment();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(cp.clinicplast.asus.operationcp.R.id.main,nesne,"fragment");
        transaction.commit();
    }




    public void getRates() {

        DownloadData downloadData = new DownloadData();
        try {
            String url = "http://data.fixer.io/api/latest?access_key=c789b2c259490639ee7edab6ff1647a7&format=1";
            downloadData.execute(url);
        }
        catch (Exception e) {

        }

    }

    private class DownloadData extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            URL url;
            HttpURLConnection httpURLConnection;
            try {
                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();
                while (data > 0) {

                    char character = (char) data;

                    result += character;

                    data = inputStreamReader.read();

                }
                return result;

            } catch (Exception e) {
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject jsonObject = new JSONObject(s);
                String base = jsonObject.getString("base");
                String rates = jsonObject.getString("rates");
                JSONObject jsonObject1 = new JSONObject(rates);
                turkishlira = jsonObject1.getString("TRY");
                usd = jsonObject1.getString("USD");
                //System.out.println("try:"+turkishlira);
                //System.out.println("base:" + base);
                //System.out.println("alinan data:"+s);
            }
            catch (Exception e){

            }

        }
    }

}
