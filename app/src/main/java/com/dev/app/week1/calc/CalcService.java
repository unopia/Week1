package com.dev.app.week1.calc;

/**
 * Created by 1027 on 2016-11-05.
 */

public interface CalcService {
    public int plus(CalcDTO dto);
    public int minus(CalcDTO dto);
    public int times(CalcDTO dto);
    public int div(CalcDTO dto);
    public int mod(CalcDTO dto);

}
