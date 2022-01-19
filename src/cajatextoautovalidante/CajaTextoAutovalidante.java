/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajatextoautovalidante;

import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author pedrr
 */
public class CajaTextoAutovalidante extends JPanel implements Serializable {

    public String tipoValidacion;
    private JLabel mensajeValidacion;
    private JTextField cajaTexto;
    private boolean correccion;
    private String mensajesError;

    public CajaTextoAutovalidante() {
        mensajeValidacion = new JLabel();
        cajaTexto = new JTextField();

        mensajeValidacion.setPreferredSize(new Dimension(200, 20));
        cajaTexto.setPreferredSize(new Dimension(100, 25));

        cajaTexto.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tipoValidacion == "dni" || tipoValidacion == "DNI") {
                    if (cajaTexto.getText().length() != 9) {
                        mensajeValidacion.setText("El DNI debe tener 9 digitos");
                        correccion = false;
                        mensajesError = "El DNI debe tener 9 digitos";
                    } else {
                        try {
                            String DNI = cajaTexto.getText().substring(0, 8);
                            Integer.parseInt(DNI);
                            try {
                                char letra = cajaTexto.getText().charAt(8);
                                Integer.parseInt(letra + "");
                                mensajeValidacion.setText("El ultimo digito debe ser una letra");
                                correccion = false;
                                mensajesError = "El ultimo digito debe ser una letra";
                            } catch (NumberFormatException w) {

                                mensajeValidacion.setText("Correcto");
                                correccion = true;
                            }
                        } catch (NumberFormatException w) {
                            mensajeValidacion.setText("Los primeros 8 digitos deben ser numeros y el ultimo una letra");
                            correccion = false;
                            mensajesError = "Los primeros 8 digitos deben ser numeros y el ultimo una letra";
                        }
                    }
                }
                if (tipoValidacion == "cp" || tipoValidacion == "CP") {
                    if (cajaTexto.getText().length() != 5) {
                        mensajeValidacion.setText("El codigo postal debe tener 5 digitos");
                        correccion = false;
                        mensajesError = "El codigo postal debe tener 5 digitos";
                    } else {
                        try {
                            Integer.parseInt((cajaTexto.getText()));
                            mensajeValidacion.setText("Correcto");
                            correccion = true;
                        } catch (NumberFormatException w) {
                            mensajeValidacion.setText("El codigo postal no puede tener letras");
                            correccion = false;
                            mensajesError = "El codigo postal no puede tener letras";
                        }
                    }
                }
                if (tipoValidacion == "tlf" || tipoValidacion == "TLF") {
                    {
                        if (cajaTexto.getText().length() != 9) {
                            mensajeValidacion.setText("El teléfono debe tener 9 digitos");
                            correccion = false;
                            mensajesError = "El codigo postal no puede tener letras";
                        } else {
                            try {
                                Integer.parseInt(cajaTexto.getText());
                                mensajeValidacion.setText("Correcto");
                                correccion = true;
                            } catch (NumberFormatException w) {
                                mensajeValidacion.setText("El teléfono solo puede contener números");
                                correccion = false;
                                mensajesError = "El teléfono solo puede contener números";
                            }
                        }
                    }
                }
            }
        });

        this.add(cajaTexto);

        this.add(mensajeValidacion);

    }

    
   //getters & setters para utilizar el mensaje de error y si es correcto o no fuera
    public String getTipoValidacion() {
        return tipoValidacion;
    }

    public void setTipoValidacion(String tipoValidacion) {
        this.tipoValidacion = tipoValidacion;
    }

    public boolean isCorreccion() {
        return correccion;
    }

    public void setCorreccion(boolean correccion) {
        this.correccion = correccion;
    }

    public String getMensajesError() {
        return mensajesError;
    }

    public void setMensajesError(String mensajesError) {
        this.mensajesError = mensajesError;
    }

}
