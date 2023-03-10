
package mainjava;


class Fraction {
    
   private int ch;
    private int zn;
    static private int countObj = 0;
    private static boolean flagCl = false;
    private boolean flagObj = false;

    Fraction() {
        ch = 0;
        zn = 1;
        countObj++;
    }

    Fraction(int chA, int znA) {
        countObj++;
        if (znA == 0) {
            ch = 0;
            zn = 1;
        } else {
            int nod = Nod(chA, znA);
            ch = flagCl == false ? (chA) : (chA / nod);
            zn = flagCl == false ? (znA) : (znA / nod);

        }
        if (chA < 0 && znA < 0) {
            int nod = Nod(chA, znA);
            ch = flagCl == false ? (Math.abs(chA)) : (Math.abs(chA) / nod);
            zn = flagCl == false ? (Math.abs(znA)) : (Math.abs(znA) / nod);
        }
        if (chA > 0 && znA < 0) {
            int nod = Nod(chA, znA);
            ch = flagCl == false ? (-chA) : (-(chA / nod));
            zn = flagCl == false ? (Math.abs(znA)) : (Math.abs(znA) / nod);
        }
    }

    public static void setflagCl(boolean newFlagCl) {
        flagCl = newFlagCl;
    }

    void setflagObj(boolean newFlagObj) {
        flagObj = newFlagObj;
    }

    boolean getflagCl() {
        return flagCl;
    }

    boolean getflagObj() {
        return flagObj;
    }
//метод сложения

    Fraction add(Fraction objF) {
        Fraction res = new Fraction(ch * objF.zn + objF.ch * zn, zn * objF.zn);
        if (flagCl == true) {
            res.reduse();
        }
        return res;

    }
// метод сравнения дробей

    boolean isEqual(Fraction objF) {
        if (objF == null) {
            return false;
        }
        if (ch == objF.ch && zn == objF.zn) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) return false;
        //obj.

        if (ch == ((Fraction) obj).ch && zn == ((Fraction) obj).zn)
            return true;
        return false;
    }

    /**
     * @return @throws CloneNotSupportedException
     */
    @Override
    public Fraction clone() throws CloneNotSupportedException {
        return (Fraction) super.clone();
    }

    String toFormatString() {

        return ch + "/" + zn;
    }

    @Override
    public String toString() {
        return "(" + ch + "/" + zn + ")";
    }

    public static int getCountObject() {
        return countObj;
    }

    void setZn(int znA) {
        this.zn = znA;
    }

    void setCh(int chA) {
        ch = chA;
    }

    int getZn(int znA) {
        return zn;
    }

    int getCh(int chA) {
        return ch;
    }

    void CopyFraction(Fraction obj) {
        if (obj != null) {
            ch = obj.ch;
            zn = obj.zn;
        } else {
            ch = 0;
            zn = 1;
        }
    }
//метод деления

    Fraction dev(Fraction objF) throws Exception {
        if (objF == null || objF.ch == 0) {
            throw new Exception("Devide error in Fraktion");
        }
        if (this.flagObj == true) {
            this.reduse();
        }
        if (objF.flagObj == true) {
            objF.reduse();
        }
        Fraction res = new Fraction(ch * objF.zn, zn * objF.ch);
        if (flagCl == true) {
            res.reduse();
        }
        return res;
    }
// метод вычитания

    Fraction subtraction(Fraction objF) {
        if (objF != null || objF.ch != 0) {
            if (this.flagObj == true) {
                this.reduse();
            }
            if (objF.flagObj == true) {
                objF.reduse();
            }
            Fraction res = new Fraction(ch * objF.zn - objF.ch * zn, zn * objF.zn);
            if (flagCl == true) {
                res.reduse();
            }
            return res;
        } else {
            ch = 0;
            zn = 1;
            Fraction res = new Fraction(ch, zn);
            return res;
        }
    }
// метод умножения

    Fraction multiplication(Fraction objF) {
        if (objF != null) {
            if (this.flagObj == true) {
                this.reduse();
            }
            if (objF.flagObj == true) {
                objF.reduse();
            }
            Fraction res = new Fraction(ch * objF.ch, zn * objF.zn);
            if (flagCl == true) {
                res.reduse();

            }
            return res;
        } else {
            ch = 0;
            zn = 1;
            Fraction res = new Fraction(ch, zn);
            return res;
        }
    }
// метод сокрашения дроби

    public void reduse() {
        int nod = Nod(ch, zn);
        ch = ch / nod;
        zn = zn / nod;
    }

    // метод нахождения наибольшего общего делителя
    public static int Nod(int chA, int znA) {
        int nod = 1;
        int a = Math.abs(chA);
        int b = Math.abs(znA);
        if (chA == 0 || znA == 0) {
            return 1;
        }
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        nod = a + b;
        return nod;
    }
}
