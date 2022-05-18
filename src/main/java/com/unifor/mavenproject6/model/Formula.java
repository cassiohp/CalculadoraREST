/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unifor.mavenproject6.model;

/**
 *
 * @author wander
 */
public class Formula {
    
    private int dig1;
    private int dig2;

    public Formula(int dig1, int dig2) {
        this.dig1 = dig1;
        this.dig2 = dig2;
    }
    
    public Formula() {
        
    }

    public int getDig1() {
        return dig1;
    }

    public void setDig1(int dig1) {
        this.dig1 = dig1;
    }

    public int getDig2() {
        return dig2;
    }

    public void setDig2(int dig2) {
        this.dig2 = dig2;
    }
    
    
}
