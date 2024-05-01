package br.com.alura.conversormoeda.modelos;

public class Conversões {
    private double conversionResult;
    private double conversion_rate;
    private double valueForConversion;

    public double getValueForConversion() {
        return valueForConversion;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    public void setConversionResult(double conversionResult) {
        this.conversionResult = conversionResult;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }


    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    //Metodo para definir o valor da conversão adquirida pela API.
    public double calculateConversionResult(double valueForConversion, double conversionRate){
        this.conversionResult = valueForConversion * conversionRate;

        return conversionResult;
    }
}
