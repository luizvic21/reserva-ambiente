package br.edu.ifsc.aluno.victor.Utils;

import java.time.LocalDate;

public class DateUtils {

    public static String toStringFormatBrasil(LocalDate data) {
        return String.format("%d/%d/%d", data.getDayOfMonth(), data.getMonthValue(), data.getYear());
    }
}
