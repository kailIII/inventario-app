/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.inventario.entidades;

import java.util.List;


/**
 *
 * @author Erick
 */
public class jqGridModel<T> {
    private int page;
    private int total;
    private int records;
    private List<T> rows;

    public jqGridModel(int pagina, int totalPaginas, int totalRegistros, List<T> registros) {
        this.page = pagina;
        this.total = totalPaginas;
        this.records = totalRegistros;
        this.rows = registros;
    }

    public jqGridModel(){}
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
