package cp.clinicplast.asus.operationcp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class fragment extends Fragment {


    public static TextView fiyatfrg;
    Button buton;
    FragmentManager manager;
    FragmentTransaction transaction;
    ArrayList<String> dizi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(cp.clinicplast.asus.operationcp.R.layout.fragment,container,false);
        manager=getFragmentManager();
        buton=view.findViewById(cp.clinicplast.asus.operationcp.R.id.kapat);
        fiyatfrg=view.findViewById(cp.clinicplast.asus.operationcp.R.id.textfrg);
        dizi=new ArrayList<>();
        Operation nesne=new Operation();
        if(Operation.alin.isChecked()){
            dizi.add("ALIN");
        }
        if(Operation.kulak.isChecked()){
            dizi.add("KULAK");

        }
        if(Operation.burun.isChecked()){
            dizi.add("BURUN");
        }
        if(Operation.gozkapagi.isChecked()){
            dizi.add("GÖZKAPAĞI");
        }
        if(Operation.yuzgerme.isChecked()){
            dizi.add("YÜZGERME");
        }
        if(Operation.vaser.isChecked()){
            dizi.add("VASERLİPO");
        }
        if(Operation.karin.isChecked()){
            dizi.add("KARINGERME");
        }
        if(Operation.kol.isChecked()){
            dizi.add("KOLGERME");
        }
        if(Operation.memedik.isChecked()){
            dizi.add("MEMEDİKLEŞTİRME");
        }
        if(Operation.memebuy.isChecked()){
            dizi.add("MEMEBÜYÜTME");
        }
        if(Operation.memekuc.isChecked()){
            dizi.add("MEMEKÜÇÜLTME");
        }
        if(Operation.jineko.isChecked()){
            dizi.add("JINEKOMASTI");
        }
        if(Operation.labio.isChecked()){
            dizi.add("LABIOPLASTI");
        }
        if(Operation.vajina.isChecked()){
            dizi.add("VAJINOPLASTI");
        }
        if(Operation.sac.isChecked()){
            dizi.add("SAÇEKİMİ");
        }
        if(Operation.scarlet.isChecked()){
            dizi.add("SCARLET");
        }
        if(Operation.hydra.isChecked()){
            dizi.add("HYDRAFACILA");
        }
        if(Operation.yuzdolgu.isChecked()){
            dizi.add("YUZDOLGU");
        }
        fiyatfrg.setText("Toplam Operasyon Ücreti\n"+Operation.opFiyat+"€\n"+nesne.trFiyat+"₺\n"+Operation.usdFiyat+"$\n"+dizi.toString());
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment nesne= (fragment) manager.findFragmentByTag("fragment");
                transaction=manager.beginTransaction();
                if(nesne!=null){
                    transaction.remove(nesne);
                    transaction.commit();
                }
                dizi.clear();

            }
        });
        return view;
    }
}
