package cp.clinicplast.asus.operationcp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button fiyatVer,fiyatListesi;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(cp.clinicplast.asus.operationcp.R.layout.activity_main);

        fiyatVer=findViewById(cp.clinicplast.asus.operationcp.R.id.fiyatVer);
        fiyatListesi=findViewById(cp.clinicplast.asus.operationcp.R.id.fiyatListesi);

        fiyatVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),Operation.class);
                startActivity(intent);
            }
        });
        fiyatListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(getApplicationContext(),OperationMoney.class);
                startActivity(intent);
            }
        });

        FirebaseDatabase database;
        DatabaseReference myRef;
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("FiyatListesi");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.getValue().toString();
                Log.e("yusufum",dataSnapshot.getValue().toString()+"");
                OperationMoney.alin=Integer.parseInt(dataSnapshot.child("alin").getValue().toString());
                OperationMoney.kulak=Integer.parseInt(dataSnapshot.child("kulak").getValue().toString());
                OperationMoney.burun=Integer.parseInt(dataSnapshot.child("burun").getValue().toString());
                OperationMoney.gozkapagi=Integer.parseInt(dataSnapshot.child("goz").getValue().toString());
                OperationMoney.yuzgerme=Integer.parseInt(dataSnapshot.child("yuz").getValue().toString());
                OperationMoney.vaser=Integer.parseInt(dataSnapshot.child("vaser").getValue().toString());
                OperationMoney.karin=Integer.parseInt(dataSnapshot.child("karin").getValue().toString());
                OperationMoney.kol=Integer.parseInt(dataSnapshot.child("kol").getValue().toString());
                OperationMoney.memedik=Integer.parseInt(dataSnapshot.child("memedik").getValue().toString());
                OperationMoney.memebuy=Integer.parseInt(dataSnapshot.child("memebuy").getValue().toString());
                OperationMoney.memekuc=Integer.parseInt(dataSnapshot.child("memekuc").getValue().toString());
                OperationMoney.jineko=Integer.parseInt(dataSnapshot.child("jineko").getValue().toString());
                OperationMoney.labio=Integer.parseInt(dataSnapshot.child("labio").getValue().toString());
                OperationMoney.vajina=Integer.parseInt(dataSnapshot.child("vajin").getValue().toString());
                OperationMoney.sac=Integer.parseInt(dataSnapshot.child("sac").getValue().toString());
                OperationMoney.scarlet=Integer.parseInt(dataSnapshot.child("scar").getValue().toString());
                OperationMoney.hydra=Integer.parseInt(dataSnapshot.child("hydr").getValue().toString());
                OperationMoney.yuzdolg=Integer.parseInt(dataSnapshot.child("yuzdol").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
