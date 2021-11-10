package com.example.speekers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Letter extends AppCompatActivity{
    public static String letter;
    //MediaPlayer
    private MediaPlayer player;
    private File file;
    private ImageButton startRec,stopRec,playRec,deleteRec,prev,next;
    private ImageView imageView;
    private int picture[];
    private int voice[];
    private int index =0;
    //MediaRecorder
    String pathSave = "";
    MediaRecorder mediarecorder;
    final int REQUEST_PERMISSION_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels/2;
        int width = (int) Math.round(displayMetrics.widthPixels/1.5);
        int orientation = getResources().getConfiguration().orientation;
        setTheme(menuSetting.theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter);
        if(letter == "ż"){
            picture = new int[] {R.drawable.burza,R.drawable.filizanka,R.drawable.grzanka,R.drawable.grzebien,R.drawable.grzejnik,R.drawable.grzyb,R.drawable.jarzebina,
                    R.drawable.jezyny,R.drawable.kaluza,R.drawable.kolezanki,R.drawable.kozuch,R.drawable.orzech,R.drawable.orzel,R.drawable.pizama,R.drawable.roza,R.drawable.rzodkiew,
                    R.drawable.talerz,R.drawable.wieza,R.drawable.wiezba,R.drawable.zaba,R.drawable.zmija,R.drawable.zoltko,R.drawable.zolw,R.drawable.zonkil,R.drawable.zyrafa};
            voice = new int[] {R.raw.burza,R.raw.filizanka,R.raw.grzanka,R.raw.grzebien,R.raw.grzejnik,R.raw.grzyb,R.raw.jarzebina,R.raw.jezyny,R.raw.kaluza,R.raw.kolezanki,
                    R.raw.kozuch,R.raw.orzech,R.raw.orzel,R.raw.pizama,R.raw.roza,R.raw.rzodkiew, R.raw.talerz,R.raw.wieza,R.raw.wiezba,R.raw.zaba,R.raw.zmija,R.raw.zoltko, R.raw.zolw,
                    R.raw.zonkil,R.raw.zyrafa};
        } else if(letter == "c"){
            picture = new int[]{R.drawable.baletnica,R.drawable.cebula,R.drawable.cegly,R.drawable.cena,R.drawable.centymetr,R.drawable.chlopiec,R.drawable.ciasto,R.drawable.cukierki,
                    R.drawable.cylinder,R.drawable.cyrk,R.drawable.cytryna,R.drawable.klocek,R.drawable.koc,R.drawable.krawiec,R.drawable.latawiec,R.drawable.materac,R.drawable.motocykl,
                    R.drawable.piec,R.drawable.plecak,R.drawable.policjant,R.drawable.proca,R.drawable.tablica,R.drawable.taca,R.drawable.walec,R.drawable.widelec};
            voice = new int[]{R.raw.baletnica,R.raw.cebula,R.raw.cegly,R.raw.cena,R.raw.centymetr,R.raw.chlopiec,R.raw.ciasto,R.raw.cukierki,R.raw.cylinder,R.raw.cyrk,
                    R.raw.cytryna,R.raw.klocek,R.raw.koc,R.raw.krawiec,R.raw.latawiec,R.raw.materac,R.raw.motocykl, R.raw.piec,R.raw.plecak,R.raw.policjant,R.raw.proca,R.raw.tablica,R.raw.taca,R.raw.walec,R.raw.widelec};
        }else if(letter == "cz") {
            picture = new int[]{R.drawable.beczka, R.drawable.bicz, R.drawable.biegacz, R.drawable.brodacz, R.drawable.czapka, R.drawable.czekolada, R.drawable.czepek, R.drawable.kaczka,
                    R.drawable.klacz, R.drawable.klucz, R.drawable.koniczyna, R.drawable.krolewicz, R.drawable.oczy, R.drawable.owieczka, R.drawable.palacz, R.drawable.paczek, R.drawable.placz,
                    R.drawable.porecz, R.drawable.puchacz, R.drawable.tecza, R.drawable.wlamywacz, R.drawable.czarodziej, R.drawable.cztery};
            voice = new int[]{R.raw.beczka, R.raw.bicz, R.raw.biegacz, R.raw.brodacz, R.raw.czapka, R.raw.czekolada, R.raw.czepek, R.raw.kaczka, R.raw.klacz, R.raw.klucz, R.raw.koniczyna,
                    R.raw.krolewicz, R.raw.oczy, R.raw.owieczka, R.raw.palacz, R.raw.paczek, R.raw.placz, R.raw.porecz, R.raw.puchacz, R.raw.tencza, R.raw.wlamywacz, R.raw.czarodziej, R.raw.cztery};
        }else if(letter == "ć") {
            picture = new int[]{R.drawable.babcia,R.drawable.bocian,R.drawable.ciagnik,R.drawable.ciasto,R.drawable.cielak,R.drawable.cma,R.drawable.jesc,R.drawable.kapcie,R.drawable.kosc,R.drawable.lisc,
                    R.drawable.nic,R.drawable.paproc,R.drawable.pic,R.drawable.pieec,R.drawable.pociag,R.drawable.siec};
            voice = new int[]{R.raw.babcia,R.raw.bocian,R.raw.ciagnik,R.raw.ciasto,R.raw.cielak,R.raw.cma,R.raw.jesc,R.raw.kapcie,R.raw.kosc,R.raw.lisc,R.raw.nic,R.raw.paproc,R.raw.pic,R.raw.pieec,R.raw.pociag,R.raw.siec};
        }else if(letter == "dz") {
            picture = new int[]{R.drawable.dzbanek,R.drawable.dziadek,R.drawable.dzieci,R.drawable.dziesiec,R.drawable.dzwon,R.drawable.dzwonnica,R.drawable.kukurydza,
                    R.drawable.ogrodzenie,R.drawable.pedzel,R.drawable.pieniadze, R.drawable.rodzynki,R.drawable.rydz,R.drawable.twierdza,R.drawable.wodz};
            voice = new int[]{R.raw.dzbanek,R.raw.dziadek,R.raw.dzieci,R.raw.dziesiec,R.raw.dzwon,R.raw.dzwonnica,R.raw.kukurydza,R.raw.ogrodzenie,R.raw.pedzel,R.raw.pieniadze,
                    R.raw.rodzynki,R.raw.rydz,R.raw.twierdza,R.raw.wodz};
        }else if(letter == "dż") {
            picture = new int[]{R.drawable.brydz,R.drawable.drozdzowka,R.drawable.dzdzownica,R.drawable.dzem,R.drawable.dzentelmen,R.drawable.dzin,R.drawable.dzokej,
                    R.drawable.dzungla};
            voice = new int[]{R.raw.brydz,R.raw.drozdzowka,R.raw.dzdzownica,R.raw.dzem,R.raw.dzentelmen,R.raw.dzin,R.raw.dzokej,R.raw.dzungla};
        }else if(letter == "g") {
            picture = new int[]{R.drawable.biegacz,R.drawable.cegly,R.drawable.flaga,R.drawable.gasienica,R.drawable.gazela,R.drawable.gitara,R.drawable.globus,
                    R.drawable.glowa,R.drawable.gofry,R.drawable.gol,R.drawable.golab,R.drawable.goral,R.drawable.guma,R.drawable.igla,R.drawable.magia,
                    R.drawable.noga,R.drawable.ogien,R.drawable.ogon,R.drawable.papuga,R.drawable.waga,R.drawable.wagon,R.drawable.zegar};
            voice = new int[]{R.raw.biegacz,R.raw.cegly,R.raw.flaga,R.raw.gasienica,R.raw.gazela,R.raw.gitara,R.raw.globus, R.raw.glowa,R.raw.gofry,R.raw.gol,
                    R.raw.golab,R.raw.goral,R.raw.guma,R.raw.igla,R.raw.magia,R.raw.noga,R.raw.ogien,R.raw.ogon,R.raw.papuga,R.raw.waga,R.raw.wagon,R.raw.zegar};
        }else if(letter == "k") {
            picture = new int[]{R.drawable.balwanek,R.drawable.byk,R.drawable.chomik,R.drawable.jezyk,R.drawable.klocek,R.drawable.kolejka,R.drawable.lek,
                    R.drawable.lizak,R.drawable.pilka,R.drawable.slimak,R.drawable.smok,R.drawable.sok,R.drawable.walek,R.drawable.wozek};
            voice = new int[]{R.raw.balwanek,R.raw.byk,R.raw.chomik,R.raw.jezyk,R.raw.klocek,R.raw.kolejka,R.raw.lek,R.raw.lizak,R.raw.pilka,R.raw.slimak,R.raw.smok,
                    R.raw.sok,R.raw.walek,R.raw.wozek};
        }else if(letter == "l") {
            picture = new int[]{R.drawable.balon,R.drawable.cebula,R.drawable.klon,R.drawable.kula,R.drawable.lalka,R.drawable.lampa,R.drawable.las,R.drawable.latawiec,R.drawable.lato,
            R.drawable.lemoniada,R.drawable.lew,R.drawable.lis,R.drawable.lisc,R.drawable.list,R.drawable.lodowka,R.drawable.lody,R.drawable.lupa,R.drawable.maliny,R.drawable.mleko,
            R.drawable.motyl,R.drawable.pedzel,R.drawable.pudel,R.drawable.sol,R.drawable.telefon,R.drawable.walizka,R.drawable.widelec};
            voice = new int[]{R.raw.balon,R.raw.cebula,R.raw.klon,R.raw.kula,R.raw.lalka,R.raw.lampa,R.raw.las,R.raw.latawiec,R.raw.lato,R.raw.lemoniada,R.raw.lew,R.raw.lis,
            R.raw.lisc,R.raw.list,R.raw.lodowka,R.raw.lody,R.raw.lupa,R.raw.maliny,R.raw.mleko,R.raw.motyl,R.raw.pedzel,R.raw.pudel,R.raw.sol,R.raw.telefon,R.raw.walizka,R.raw.widelec};
        }else if(letter == "r") {
            picture = new int[]{R.drawable.adres,R.drawable.atrament,R.drawable.biedronka,R.drawable.bobr,R.drawable.drabina,R.drawable.droga,R.drawable.drugi,R.drawable.drut,
            R.drawable.futro,R.drawable.hydrant,R.drawable.kokardka,R.drawable.koldra,R.drawable.pietruszka,R.drawable.podrecznik,R.drawable.rabarbar,R.drawable.rabus,R.drawable.ryz,
            R.drawable.trabant,R.drawable.trampki,R.drawable.tron,R.drawable.truskawka,R.drawable.wiadro,R.drawable.wydra,R.drawable.zegar};
            voice = new int[]{R.raw.adres,R.raw.atrament,R.raw.biedronka,R.raw.bobr,R.raw.drabina,R.raw.droga,R.raw.drugi,R.raw.drut,R.raw.futro,R.raw.hydrant,R.raw.kokardka,R.raw.koldra,
                    R.raw.pietruszka,R.raw.podrecznik,R.raw.rabarbar,R.raw.rabus,R.raw.ryz,R.raw.trabant,R.raw.trampki,R.raw.tron,R.raw.truskawka,R.raw.wiadro,R.raw.wydra,R.raw.zegar};
        }else if(letter == "s") {
            picture = new int[]{R.drawable.kaktusy,R.drawable.kapusta,R.drawable.lis,R.drawable.liscie,R.drawable.miska,R.drawable.most,R.drawable.osa,R.drawable.pasterz,
                    R.drawable.pasy,R.drawable.pies,R.drawable.sabina,R.drawable.sad,R.drawable.samolot,R.drawable.skarpetki,R.drawable.slonce,R.drawable.smok,R.drawable.sosna,
                    R.drawable.sowa,R.drawable.sojka,R.drawable.spodnie,R.drawable.stado,R.drawable.stolek,R.drawable.stonoga,R.drawable.sweter,R.drawable.sylwek,R.drawable.termos,
                    R.drawable.truskawki};
            voice = new int[]{R.raw.kaktusy,R.raw.kapusta,R.raw.lis,R.raw.liscie,R.raw.miska,R.raw.most,R.raw.osa,R.raw.pasterz,R.raw.pasy,R.raw.pies,R.raw.sabina,R.raw.sad,
                    R.raw.samolot,R.raw.skarpetki,R.raw.slonce,R.raw.smok,R.raw.sosna,R.raw.sowa,R.raw.sojka,R.raw.spodnie,R.raw.stado,R.raw.stolek,R.raw.stonoga,R.raw.sweter,R.raw.sylwek,
                    R.raw.termos,R.raw.truskawki};
        }else if(letter == "sz") {
            picture = new int[]{R.drawable.groszek,R.drawable.gruszka,R.drawable.kasztan,R.drawable.kieliszek,R.drawable.klosz,R.drawable.koszulka,R.drawable.maszyna,R.drawable.muszla,
                    R.drawable.mysz,R.drawable.naszyjnik,R.drawable.piuropusz,R.drawable.poduszka,R.drawable.puszka,R.drawable.szalik,R.drawable.szampan,R.drawable.szczoteczka,R.drawable.szerszen,
                    R.drawable.szop,R.drawable.szuflada,R.drawable.szynka,R.drawable.tusz,R.drawable.uszy,R.drawable.wieszak};
            voice = new int[]{R.raw.groszek,R.raw.gruszka,R.raw.kasztan,R.raw.kieliszek,R.raw.klosz,R.raw.koszulka,R.raw.maszyna,R.raw.muszla,R.raw.mysz,R.raw.naszyjnik,R.raw.piuropusz,R.raw.poduszka,
                    R.raw.puszka,R.raw.szalik,R.raw.szampan,R.raw.szczoteczka,R.raw.szerszen,R.raw.szop,R.raw.szuflada,R.raw.szynka,R.raw.tusz,R.raw.uszy,R.raw.wieszak};
        }else if(letter == "ś") {
            picture = new int[]{R.drawable.gesi,R.drawable.hustawka,R.drawable.jesien,R.drawable.kubus,R.drawable.los,R.drawable.osilek,R.drawable.osiol,R.drawable.rys,R.drawable.siano,
                    R.drawable.siatka,R.drawable.siedem,R.drawable.siekiera,R.drawable.sikorka,R.drawable.siodelko,R.drawable.sitko,R.drawable.slady,R.drawable.slimak,R.drawable.sliwka,
                    R.drawable.slub,R.drawable.smietnik,R.drawable.sniadanie,R.drawable.snieg,R.drawable.swiat,R.drawable.swinia,R.drawable.tasma,R.drawable.tatus,R.drawable.wies};
            voice = new int[]{R.raw.gesi,R.raw.hustawka,R.raw.jesien,R.raw.kubus,R.raw.los,R.raw.osilek,R.raw.osiol,R.raw.rys,R.raw.siano,R.raw.siatka,R.raw.siedem,R.raw.siekiera,
                    R.raw.sikorka,R.raw.siodelko,R.raw.sitko,R.raw.slady,R.raw.slimak,R.raw.sliwka,R.raw.slub,R.raw.smietnik,R.raw.sniadanie,R.raw.snieg,R.raw.swiat,R.raw.swinia,
                    R.raw.tasma,R.raw.tatus,R.raw.wies};
        }else if(letter == "z") {
            picture = new int[]{R.drawable.jezyk,R.drawable.waza,R.drawable.zab,R.drawable.zabawka,R.drawable.zakret,R.drawable.zamek,R.drawable.zapalka,R.drawable.zapalniczka,R.drawable.zaslona,
                    R.drawable.zboze,R.drawable.zbroja,R.drawable.zebra,R.drawable.zegar,R.drawable.zeszyt,R.drawable.ziarna,R.drawable.zjezdzalnia,R.drawable.zlew,R.drawable.zlodziej,
                    R.drawable.zloto,R.drawable.zmywarka,R.drawable.znaczek,R.drawable.znak,R.drawable.zupa};
            voice = new int[]{R.raw.jezyk,R.raw.waza,R.raw.zab,R.raw.zabawka,R.raw.zakret,R.raw.zamek,R.raw.zapalka,R.raw.zapalniczka,R.raw.zaslona,R.raw.zboze,R.raw.zbroja,R.raw.zebra,
                    R.raw.zegar,R.raw.zeszyt,R.raw.ziarna,R.raw.zjezdzalnia,R.raw.zlew,R.raw.zlodziej, R.raw.zloto,R.raw.zmywarka,R.raw.znaczek,R.raw.znak,R.raw.zupa};
        }
        imageView = findViewById(R.id.image);
        imageView.getLayoutParams().height = height;
        imageView.getLayoutParams().width = width;
        if((orientation == 2) && (displayMetrics.widthPixels>320)){
            imageView.getLayoutParams().width = (int) Math.round(displayMetrics.widthPixels/3); ;
        }
        imageView.setBackgroundResource(picture[0]);
        startRec = findViewById(R.id.rec);
        stopRec = findViewById(R.id.sRec);
        playRec = findViewById(R.id.playRec);
        deleteRec = findViewById(R.id.deleteRec);
        prev = findViewById(R.id.previous);
        next = findViewById(R.id.next);
        startRec.setEnabled(true);
        stopRec.setEnabled(false);
        playRec.setEnabled(false);
        deleteRec.setEnabled(false);
        if(!checkPermissionFromDevice())
            requestPermission();
    }

    private void setupMediaRecorder() {
        mediarecorder = new MediaRecorder();
        mediarecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediarecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediarecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediarecorder.setOutputFile(pathSave);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO
        },REQUEST_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case REQUEST_PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }

    private boolean checkPermissionFromDevice() {
        int write_external_storage_results = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        return write_external_storage_results == PackageManager.PERMISSION_GRANTED && record_audio_result == PackageManager.PERMISSION_GRANTED;
    }
    public void buttonRec(View view) {
        startRec.setEnabled(false);
        stopRec.setEnabled(true);
        playRec.setEnabled(false);
        deleteRec.setEnabled(false);
        next.setEnabled(false);
        prev.setEnabled(false);
        if(checkPermissionFromDevice()){
            pathSave = Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+ UUID.randomUUID().toString()+"_audio.mp3";
            setupMediaRecorder();
            try {
                mediarecorder.prepare();
                mediarecorder.start();
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            requestPermission();
        }
    }
    public void stopRec(View view) {
        startRec.setEnabled(false);
        stopRec.setEnabled(false);
        playRec.setEnabled(true);
        deleteRec.setEnabled(true);
        next.setEnabled(false);
        prev.setEnabled(false);
        mediarecorder.stop();
    }
    public void playRec(View view) {
        startRec.setEnabled(false);
        stopRec.setEnabled(false);
        playRec.setEnabled(true);
        deleteRec.setEnabled(true);
        next.setEnabled(false);
        prev.setEnabled(false);
        player = new MediaPlayer();
        try {
            player.setDataSource(pathSave);
            player.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
        player.start();
    }
    public void deleteFile(View view) {
        startRec.setEnabled(true);
        stopRec.setEnabled(false);
        playRec.setEnabled(false);
        deleteRec.setEnabled(false);
        next.setEnabled(true);
        prev.setEnabled(true);
        file = new File(pathSave);
        file.delete();
        pathSave = "";
    }

    public void stopPlaying(){
        if(player != null){
            player.stop();
            player.release();
            player = null;
        }
    }
    public void backToMenu(View view) {
        Intent intent = new Intent(this, MenuLetter.class);
        startActivity(intent);
    }
    public void buttonNext(View view) {
        if(index<picture.length-1){
            index++;
            imageView.setBackgroundResource(picture[index]);
            stopPlaying();
        }
    }
    public void buttonPrevious(View view) {
        if(index>0){
            index--;
            imageView.setBackgroundResource(picture[index]);
            stopPlaying();
        }
    }
    public void buttonPlay(View view) {
        stopPlaying();
        player = MediaPlayer.create(this, voice[index]);
        player.start();
    }



}