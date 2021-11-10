package com.example.speekers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class ThirdExam extends AppCompatActivity {
    private int [] picture = {R.drawable.babcia,R.drawable.baletnica,R.drawable.cylinder,R.drawable.atrament,
            R.drawable.zaba,R.drawable.zmija,R.drawable.brydz,R.drawable.cebula,
            R.drawable.kolezanki,R.drawable.policjant,R.drawable.kozuch,R.drawable.orzech,
            R.drawable.bicz,R.drawable.biegacz,R.drawable.roza,R.drawable.brodacz,
            R.drawable.wiezba,R.drawable.ciagnik,R.drawable.ciasto,R.drawable.cielak,
            R.drawable.dzbanek,R.drawable.tecza,R.drawable.dziadek,R.drawable.dzieci,
            R.drawable.palacz,R.drawable.drozdzowka,R.drawable.dzdzownica,R.drawable.dzem,
            R.drawable.flaga,R.drawable.gasienica,R.drawable.klucz,R.drawable.gazela,
            R.drawable.balwanek,R.drawable.zegar,R.drawable.byk,R.drawable.chomik,
            R.drawable.lemoniada,R.drawable.lew,R.drawable.lis,R.drawable.futro,
            R.drawable.pietruszka,R.drawable.podrecznik,R.drawable.rabarbar,R.drawable.jezyny,
            R.drawable.koc,R.drawable.sowa,R.drawable.sojka,R.drawable.spodnie,
            R.drawable.szuflada,R.drawable.szynka,R.drawable.slonce,R.drawable.tusz,
            R.drawable.dzin,R.drawable.smietnik,R.drawable.sniadanie,R.drawable.snieg,
            R.drawable.zbroja,R.drawable.zebra,R.drawable.zegar,R.drawable.wlamywacz,
            R.drawable.wieza,R.drawable.osiol,R.drawable.rys,R.drawable.siano,
            R.drawable.szalik,R.drawable.szampan,R.drawable.oczy,R.drawable.szczoteczka,
            R.drawable.ogon,R.drawable.cztery,R.drawable.papuga,R.drawable.waga,
            R.drawable.zyrafa,R.drawable.lody,R.drawable.lupa,R.drawable.maliny,
            R.drawable.owieczka,R.drawable.zolw,R.drawable.palacz, R.drawable.paczek,
            R.drawable.gofry,R.drawable.gol,R.drawable.dzem ,R.drawable.golab};

    private int [] voice =   {R.raw.babcia,R.raw.baletnica,R.raw.cylinder,R.raw.atrament,
            R.raw.zaba,R.raw.zmija,R.raw.brydz,R.raw.cebula,
            R.raw.kolezanki,R.raw.policjant,R.raw.kozuch,R.raw.orzech,
            R.raw.bicz,R.raw.biegacz,R.raw.roza,R.raw.brodacz,
            R.raw.wiezba,R.raw.ciagnik, R.raw.ciasto,R.raw.cielak,
            R.raw.dzbanek,R.raw.tencza,R.raw.dziadek,R.raw.dzieci,
            R.raw.palacz,R.raw.drozdzowka,R.raw.dzdzownica,R.raw.dzem,
            R.raw.flaga,R.raw.gasienica,R.raw.klucz,R.raw.gazela,
            R.raw.balwanek,R.raw.zegar,R.raw.byk,R.raw.chomik,
            R.raw.lemoniada,R.raw.lew,R.raw.lis,R.raw.futro,
            R.raw.pietruszka,R.raw.podrecznik,R.raw.rabarbar,R.raw.jezyny,
            R.raw.koc,R.raw.sowa,R.raw.sojka,R.raw.spodnie,
            R.raw.szuflada,R.raw.szynka,R.raw.slonce,R.raw.tusz,
            R.raw.dzin,R.raw.smietnik,R.raw.sniadanie,R.raw.snieg,
            R.raw.zbroja,R.raw.zebra,R.raw.zegar,R.raw.wlamywacz,
            R.raw.wieza,R.raw.osiol,R.raw.rys,R.raw.siano,
            R.raw.szalik,R.raw.szampan,R.raw.oczy,R.raw.szczoteczka,
            R.raw.ogon,R.raw.cztery,R.raw.papuga,R.raw.waga,
            R.raw.zyrafa,R.raw.lody,R.raw.lupa,R.raw.maliny,
            R.raw.owieczka,R.raw.zolw,R.raw.palacz, R.raw.paczek,
            R.raw.gofry,R.raw.gol,R.raw.dzem ,R.raw.golab};

    private int [] Pvoice = {R.raw.beczka,R.raw.jezyny,R.raw.wieza,R.raw.czapka,R.raw.kapcie,R.raw.pedzel,R.raw.dzungla,R.raw.noga,R.raw.slimak,R.raw.lalka,R.raw.hydrant,R.raw.pies,R.raw.piuropusz,R.raw.siedem,R.raw.zupa,R.raw.gesi,R.raw.szop,
            R.raw.gol,R.raw.lis, R.raw.czarodziej,R.raw.guma};
    private ImageView Image1,Image2,Image3,Image4;
    private MediaPlayer player;
    private int index =0;
    private int ind =0;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(menuSetting.theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_exam);
        Image1 = findViewById(R.id.Image1);
        Image2 = findViewById(R.id.Image2);
        Image3 = findViewById(R.id.Image3);
        Image4 = findViewById(R.id.Image4);
        txt = findViewById(R.id.Text1);
        setImage(index);
    }

    public void setImage(int index){
        Image1.setBackgroundResource(picture[index]);
        Image1.setTag(picture[index]);
        Image2.setBackgroundResource(picture[index+1]);
        Image2.setTag(picture[index+1]);
        Image3.setBackgroundResource(picture[index+2]);
        Image3.setTag(picture[index+2]);
        Image4.setBackgroundResource(picture[index+3]);
        Image4.setTag(picture[index+3]);
    }

    public void Image1Click(View view) {
       if((Image1.getTag().hashCode() == R.drawable.wiezba) || (Image1.getTag().hashCode() == R.drawable.palacz) || (Image1.getTag().hashCode() == R.drawable.koc) || (Image1.getTag().hashCode() == R.drawable.dzin) || (Image1.getTag().hashCode() == R.drawable.wieza) || (Image1.getTag().hashCode() == R.drawable.zyrafa)){
           ind++;
           index+=4;
           setImage(index);
        }else{
           startPlaying(index);
        }
    }
    public void Image2Click(View view) {
        if((Image2.getTag().hashCode() == R.drawable.policjant) || (Image2.getTag().hashCode() == R.drawable.tecza) ||(Image2.getTag().hashCode() == R.drawable.zegar) || (Image2.getTag().hashCode() == R.drawable.cztery) || (Image2.getTag().hashCode() == R.drawable.zolw)){
            ind++;
            index+=4;
            setImage(index);
        }else{
            startPlaying(index+1);
        }
    }
    public void Image3Click(View view) {
        if((Image3.getTag().hashCode() == R.drawable.roza) || (Image3.getTag().hashCode() == R.drawable.klucz) || (Image3.getTag().hashCode() == R.drawable.slonce)|| (Image3.getTag().hashCode() == R.drawable.oczy)){
            ind++;
            index+=4;
            setImage(index);
        }else if((Image3.getTag().hashCode() == R.drawable.dzem)){
            Intent intent = new Intent(this, MenuLetter.class);
            startActivity(intent);
        }else{
            startPlaying(index+2);
        }
    }
    public void Image4Click(View view) {
        if((Image4.getTag().hashCode() == R.drawable.atrament) || (Image4.getTag().hashCode() == R.drawable.cebula) || (Image4.getTag().hashCode() == R.drawable.futro) || (Image4.getTag().hashCode() == R.drawable.jezyny) || (Image4.getTag().hashCode() == R.drawable.wlamywacz)){
            ind++;
            index+=4;
            setImage(index);
        } else{
            startPlaying(index+3);
        }
    }
    public void stopPlaying(){
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
    public void startPlaying(int index){
        stopPlaying();
        player = MediaPlayer.create(this, voice[index]);
        player.start();
    }

    public void PlayVoice(View view) {
        stopPlaying();
        player = MediaPlayer.create(this, Pvoice[ind]);
        player.start();
    }
}