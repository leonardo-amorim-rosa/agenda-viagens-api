package br.com.leoamorimrosa.reserva;

import br.com.leoamorimrosa.cliente.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Reserva extends PanacheEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    public Cliente cliente;
}
