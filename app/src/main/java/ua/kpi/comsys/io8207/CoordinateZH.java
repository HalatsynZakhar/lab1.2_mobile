package ua.kpi.comsys.io8207;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import static java.lang.Math.round;

public class CoordinateZH extends Direction {

    CoordinateZH(){
        this.gradus=0;
        this.minuta=0;
        this.secunda=0;
    }

    @NonNull
    @Override
    public String toString() {
        return outCoordinate();
    }
    CoordinateZH(int gradus, int minuta, int secunda, boolean dolgotqZeroShurotaone){
        if(dolgotqZeroShurotaone){
            if ((gradus >= -90) && (gradus <= 90)){
                this.gradus = gradus;
            }
        }else{
           if ((gradus >= -180) && (gradus <= 180)) {
                this.gradus = gradus;
            }
        }
        if((minuta >= 0) && (minuta <= 59)) {
            this.minuta = minuta;
        }
        if((secunda >= 0) && (secunda <= 59)) {
            this.secunda = secunda;
        }

        this.dolgotqZeroShurotaone = dolgotqZeroShurotaone;
    }

    String outCoordinate(){
        String outText = "";
        if (this.dolgotqZeroShurotaone){
            if(this.gradus > 0){
                outText = "N";
            }
            else if(this.gradus <0){
                outText = "S";
            }
        } else {
            if(this.gradus > 0) {
                outText = "E";
            } else if (this.gradus < 0) {
                outText = "W";
            }
        }
        return this.gradus + "° " + this.minuta + "' " + this.secunda + "'' " + outText;
    }

    String outCoordinate2() {
        String outText = "";
        if (this.dolgotqZeroShurotaone) {
            if (this.gradus > 0) {
                outText = "N";
            } else if (this.gradus < 0) {
                outText = "S";
            }
        } else {
            if (this.gradus > 0) {
                outText = "E";
            } else if (this.gradus < 0) {
                outText = "W";
            }
        }
        return this.gradus + "." + round( (this.minuta*60 + this.secunda)/3.6*10000) + outText;
    }

    CoordinateZH outCoordinate3(int x, int y, int z, boolean shurota) {
        if (shurota != this.dolgotqZeroShurotaone){
            return null;
        }

        String outText = "";
        if (this.dolgotqZeroShurotaone) {
            if ((this.gradus + x) / 2 > 0) {
                outText = "N";
            } else if ((this.gradus + x) / 2 < 0) {
                outText = "S";
            }
        } else {
            if ((this.gradus + x) / 2 > 0) {
                outText = "E";
            } else if ((this.gradus + x) / 2 < 0) {
                outText = "W";
            }
        }
        CoordinateZH ret = new CoordinateZH((this.gradus + x) / 2,  (this.minuta + y) / 2 ,  (this.secunda + z) / 2 , shurota);
        return ret;
    }


    public static CoordinateZH outCoordinate4(int x1, int y1, int z1, boolean shurota1, int x2, int y2, int z2, boolean shurota2) {
        if (shurota1 != shurota2){
            return null;
        }

        String outText = "";
        if (shurota1) {
            if ((x1 + x2) / 2 > 0) {
                outText = "N";
            } else if ((x1 + x2) / 2 < 0) {
                outText = "S";
            }
        } else {
            if ((x1 + x2) / 2 > 0) {
                outText = "E";
            } else if ((x1 + x2) / 2 < 0) {
                outText = "W";
            }
        }
        CoordinateZH ret = new CoordinateZH((x1 + x2) / 2,  (y1 + y2) / 2 ,  (z1 + z2) / 2 , shurota1);
        return ret;
    }

}

