package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Client;
import com.platzi.market.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "nombre", target = "client"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "celular", target = "telephone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email"),
           // @Mapping(source = "compras", target = "purchases")
    })
    Client toClient(Cliente cliente);
    List<Client> toClient(List<Cliente> clientes);

    @InheritInverseConfiguration
    //@Mapping(target = "compras", ignore = true)
    Cliente toCliente(Client client);

}
