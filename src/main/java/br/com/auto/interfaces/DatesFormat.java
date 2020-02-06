package br.com.auto.interfaces;

public interface DatesFormat {
	
	
	public String insertDaysNext(int dayNext);
	
	public String dateHours();
	
	public String dateToday();
	
//	VERIFICAR OUTRAS POSSIBILIDADES DE DATA
	
	/*
	 * public static void main(String[] args) { Date data = new Date();
	 * System.out.println("Data Agora: " + data);
	 * 
	 * Calendar c = Calendar.getInstance(); System.out.println("Data e Hora atual: "
	 * + c.getCalendarType());
	 * 
	 * c.set(Calendar.YEAR, 1995); c.set(Calendar.MONTH, Calendar.MARCH);
	 * c.set(Calendar.DAY_OF_MONTH, 20);
	 * 
	 * System.out.println("Data/Hora atual: " + c.getTime());
	 * System.out.println("Ano: " + c.get(Calendar.YEAR));
	 * System.out.println("Mês: " + c.get(Calendar.MONTH));
	 * System.out.println("Dia do Mês: " + c.get(Calendar.DAY_OF_MONTH));
	 * 
	 * c.set(2013, Calendar.FEBRUARY, 28); data = c.getTime();
	 * System.out.println("Data atual sem formatação: " + data);
	 * 
	 * // Formata a data DateFormat formataData = DateFormat.getDateInstance();
	 * System.out.println("Data atual com formatação: " + formataData.format(data));
	 * 
	 * // Formata Hora DateFormat hora = DateFormat.getTimeInstance();
	 * System.out.println("Hora formatada: " + hora.format(data));
	 * 
	 * // Formata Data e Hora DateFormat dtHora = DateFormat.getDateTimeInstance();
	 * System.out.println(dtHora.format(data));
	 * 
	 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 * System.out.println("Data formatada: "+sdf.format(data));
	 * 
	 * 
	 * Date dt = new Date();
	 * System.out.println(LocalDateTime.from(dt.toInstant().atZone(ZoneId.of("UTC"))
	 * ).plusDays(1));
	 * 
	 * System.out.println( LocalDate.of( 2017 , Month.JANUARY , 23 ) .plusDays( 4
	 * )); DatesFormat datesFormat = new DatesFormat();
	 * System.out.println(datesFormat.dateToday());
	 * System.out.println(datesFormat.dateHours());
	 * System.out.println(datesFormat.insertDaysNext(3));
	 * 
	 * }
	 * 
	 * public String dateToday() { return new
	 * SimpleDateFormat("dd/MM/yyyy").format(new Date()); }
	 * 
	 * public String dateHours() { return new
	 * SimpleDateFormat("HH:mm:ss").format(new Date()); }
	 * 
	 * public String insertDaysNext(int dayNext) { return LocalDateTime.from(new
	 * Date().toInstant().atZone(ZoneId.of("UTC"))).plusDays(dayNext).toString(); }
	 */
	
	
	

}
