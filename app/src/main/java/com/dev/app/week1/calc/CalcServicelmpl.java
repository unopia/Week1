package com.dev.app.week1.calc;

/**
 * Created by 1027 on 2016-11-05.
 */

public class CalcServicelmpl implements CalcService {
    @Override
    public int plus(CalcDTO dto) {
        return dto.getFirst()+dto.getSecond();
    }

    @Override
    public int minus(CalcDTO dto) {
        return dto.getFirst()-dto.getSecond();
    }

    @Override
    public int times(CalcDTO dto) {
        return dto.getFirst()*dto.getSecond();
    }

    @Override
    public int div(CalcDTO dto) {
        return dto.getFirst()/dto.getSecond();
    }

    @Override
    public int mod(CalcDTO dto) {
        return dto.getFirst()%dto.getSecond();
    }
}
