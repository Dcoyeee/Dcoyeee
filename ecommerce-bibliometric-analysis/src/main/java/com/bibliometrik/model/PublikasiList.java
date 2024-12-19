package com.bibliometrik.model;

import java.util.ArrayList;
import java.util.List;

public class PublikasiList {
    private List<Publikasi> publikasiList;

    public PublikasiList() {
        this.publikasiList = new ArrayList<>();
    }

    public void addPublikasi(Publikasi publikasi) {
        this.publikasiList.add(publikasi);
    }

    public void removePublikasi(Publikasi publikasi) {
        this.publikasiList.remove(publikasi);
    }

    public Publikasi getPublikasi(int index) {
        return this.publikasiList.get(index);
    }

    public int getSize() {
        return this.publikasiList.size();
    }
}
