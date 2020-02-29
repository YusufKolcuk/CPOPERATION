package cp.clinicplast.asus.operationcp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OperationMoney extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef,alinF,kulakF,burunF,gozF,yuzF,vaserF,karinF,kolF,memedikF,memebuyF,memekucF,jinekoF,labioF,vajinF,sacF,scarF,hydrF,yuzdolguF;
    public static int alin, kulak, burun, gozkapagi, yuzgerme, vaser, karin, kol, memedik, memebuy, memekuc, jineko, labio, vajina, sac, scarlet, hydra, yuzdolg;
    Button degis,kaydet;
    EditText alinE,kulakE,burunE,gozE,yuzE,vaserE,karinE,kolE,memedikE,memebuyE,memekucE,jinekoE,labioE,vajinE,sacE,scarE,hydrE,yuzdolguE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cp.clinicplast.asus.operationcp.R.layout.activity_operation_money);
        init();
        database = FirebaseDatabase.getInstance();


        myRef = database.getReference("FiyatListesi");
        alinF=myRef.child("alin");
        kulakF=myRef.child("kulak");
        burunF=myRef.child("burun");
        gozF=myRef.child("goz");
        yuzF=myRef.child("yuz");
        vaserF=myRef.child("vaser");
        karinF=myRef.child("karin");
        kolF=myRef.child("kol");
        memedikF=myRef.child("memedik");
        memebuyF=myRef.child("memebuy");
        memekucF=myRef.child("memekuc");
        jinekoF=myRef.child("jineko");
        labioF=myRef.child("labio");
        vajinF=myRef.child("vajin");
        sacF=myRef.child("sac");
        scarF=myRef.child("scar");
        hydrF=myRef.child("hydr");
        yuzdolguF=myRef.child("yuzdol");



        getData();
        degis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alinE.setEnabled(true);
                kulakE.setEnabled(true);
                burunE.setEnabled(true);
                memekucE.setEnabled(true);
                memebuyE.setEnabled(true);
                memedikE.setEnabled(true);
                hydrE.setEnabled(true);
                labioE.setEnabled(true);
                vajinE.setEnabled(true);
                kolE.setEnabled(true);
                yuzdolguE.setEnabled(true);
                jinekoE.setEnabled(true);
                scarE.setEnabled(true);
                gozE.setEnabled(true);
                sacE.setEnabled(true);
                vaserE.setEnabled(true);
                yuzE.setEnabled(true);
                karinE.setEnabled(true);
            }
        });

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alinE.setEnabled(false);
                kulakE.setEnabled(false);
                burunE.setEnabled(false);
                memekucE.setEnabled(false);
                memebuyE.setEnabled(false);
                memedikE.setEnabled(false);
                hydrE.setEnabled(false);
                labioE.setEnabled(false);
                vajinE.setEnabled(false);
                kolE.setEnabled(false);
                yuzdolguE.setEnabled(false);
                jinekoE.setEnabled(false);
                scarE.setEnabled(false);
                gozE.setEnabled(false);
                sacE.setEnabled(false);
                vaserE.setEnabled(false);
                yuzE.setEnabled(false);
                karinE.setEnabled(false);
                firbaseIslemi();
            }
        });

    }

    public void firbaseIslemi(){
        myRef = database.getReference("FiyatListesi");
        alinF=myRef.child("alin");
        alinF.setValue(alinE.getText().toString());
        kulakF=myRef.child("kulak");
        kulakF.setValue(kulakE.getText().toString());
        burunF=myRef.child("burun");
        burunF.setValue(burunE.getText().toString());
        gozF=myRef.child("goz");
        gozF.setValue(gozE.getText().toString());
        yuzF=myRef.child("yuz");
        yuzF.setValue(yuzE.getText().toString());
        vaserF=myRef.child("vaser");
        vaserF.setValue(vaserE.getText().toString());
        karinF=myRef.child("karin");
        karinF.setValue(karinE.getText().toString());
        kolF=myRef.child("kol");
        kolF.setValue(kolE.getText().toString());
        memedikF=myRef.child("memedik");
        memedikF.setValue(memedikE.getText().toString());
        memebuyF=myRef.child("memebuy");
        memebuyF.setValue(memebuyE.getText().toString());
        memekucF=myRef.child("memekuc");
        memekucF.setValue(memekucE.getText().toString());
        jinekoF=myRef.child("jineko");
        jinekoF.setValue(jinekoE.getText().toString());
        labioF=myRef.child("labio");
        labioF.setValue(labioE.getText().toString());
        vajinF=myRef.child("vajin");
        vajinF.setValue(vajinE.getText().toString());
        sacF=myRef.child("sac");
        sacF.setValue(sacE.getText().toString());
        scarF=myRef.child("scar");
        scarF.setValue(scarE.getText().toString());
        hydrF=myRef.child("hydr");
        hydrF.setValue(hydrE.getText().toString());
        yuzdolguF=myRef.child("yuzdol");
        yuzdolguF.setValue(yuzdolguE.getText().toString());
    }

    public void getData() {
       myRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               alinE.setText(dataSnapshot.child("alin").getValue().toString());
               kulakE.setText(dataSnapshot.child("kulak").getValue().toString());
               burunE.setText(dataSnapshot.child("burun").getValue().toString());
               gozE.setText(dataSnapshot.child("goz").getValue().toString());
               yuzE.setText(dataSnapshot.child("yuz").getValue().toString());
               vaserE.setText(dataSnapshot.child("vaser").getValue().toString());
               karinE.setText(dataSnapshot.child("karin").getValue().toString());
               kolE.setText(dataSnapshot.child("kol").getValue().toString());
               memedikE.setText(dataSnapshot.child("memedik").getValue().toString());
               memebuyE.setText(dataSnapshot.child("memebuy").getValue().toString());
               memekucE.setText(dataSnapshot.child("memekuc").getValue().toString());
               jinekoE.setText(dataSnapshot.child("jineko").getValue().toString());
               labioE.setText(dataSnapshot.child("labio").getValue().toString());
               vajinE.setText(dataSnapshot.child("vajin").getValue().toString());
               sacE.setText(dataSnapshot.child("sac").getValue().toString());
               scarE.setText(dataSnapshot.child("scar").getValue().toString());
               hydrE.setText(dataSnapshot.child("hydr").getValue().toString());
               yuzdolguE.setText(dataSnapshot.child("yuzdol").getValue().toString());



               alin=Integer.parseInt(dataSnapshot.child("alin").getValue().toString());
               kulak=Integer.parseInt(dataSnapshot.child("kulak").getValue().toString());
               burun=Integer.parseInt(dataSnapshot.child("burun").getValue().toString());
               gozkapagi=Integer.parseInt(dataSnapshot.child("goz").getValue().toString());
               yuzgerme=Integer.parseInt(dataSnapshot.child("yuz").getValue().toString());
               vaser=Integer.parseInt(dataSnapshot.child("vaser").getValue().toString());
               karin=Integer.parseInt(dataSnapshot.child("karin").getValue().toString());
               kol=Integer.parseInt(dataSnapshot.child("kol").getValue().toString());
               memedik=Integer.parseInt(dataSnapshot.child("memedik").getValue().toString());
               memebuy=Integer.parseInt(dataSnapshot.child("memebuy").getValue().toString());
               memekuc=Integer.parseInt(dataSnapshot.child("memekuc").getValue().toString());
               jineko=Integer.parseInt(dataSnapshot.child("jineko").getValue().toString());
               labio=Integer.parseInt(dataSnapshot.child("labio").getValue().toString());
               vajina=Integer.parseInt(dataSnapshot.child("vajin").getValue().toString());
               sac=Integer.parseInt(dataSnapshot.child("sac").getValue().toString());
               scarlet=Integer.parseInt(dataSnapshot.child("scar").getValue().toString());
               hydra=Integer.parseInt(dataSnapshot.child("hydr").getValue().toString());
               yuzdolg=Integer.parseInt(dataSnapshot.child("yuzdol").getValue().toString());
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }

    public void init() {
        degis=findViewById(cp.clinicplast.asus.operationcp.R.id.degis);
        kaydet=findViewById(cp.clinicplast.asus.operationcp.R.id.kayitE);
        alinE=findViewById(cp.clinicplast.asus.operationcp.R.id.alinE);
        kulakE=findViewById(cp.clinicplast.asus.operationcp.R.id.kulakE);
        burunE=findViewById(cp.clinicplast.asus.operationcp.R.id.burunE);
        gozE=findViewById(cp.clinicplast.asus.operationcp.R.id.gozE);
        yuzE=findViewById(cp.clinicplast.asus.operationcp.R.id.yuzE);
        vaserE=findViewById(cp.clinicplast.asus.operationcp.R.id.vaserE);
        karinE=findViewById(cp.clinicplast.asus.operationcp.R.id.karinE);
        kolE=findViewById(cp.clinicplast.asus.operationcp.R.id.kolE);
        memedikE=findViewById(cp.clinicplast.asus.operationcp.R.id.memedikE);
        memebuyE=findViewById(cp.clinicplast.asus.operationcp.R.id.memebuyE);
        memekucE=findViewById(cp.clinicplast.asus.operationcp.R.id.memekucE);
        jinekoE=findViewById(cp.clinicplast.asus.operationcp.R.id.jinekoE);
        labioE=findViewById(cp.clinicplast.asus.operationcp.R.id.labioE);
        vajinE=findViewById(cp.clinicplast.asus.operationcp.R.id.vajinE);
        sacE=findViewById(cp.clinicplast.asus.operationcp.R.id.sacE);
        scarE=findViewById(cp.clinicplast.asus.operationcp.R.id.scarE);
        hydrE=findViewById(cp.clinicplast.asus.operationcp.R.id.hydrE);
        yuzdolguE=findViewById(cp.clinicplast.asus.operationcp.R.id.yuzdolguE);
    }

}
