package by.viho.pastebin2_3.pasteSendingModule.mapper;

import org.modelmapper.ModelMapper;


public class ModelMapperConf
{

    public static  <T,G> G convertTo(T dto, Class<G> gClass){
        return  new ModelMapper().map(dto, gClass);
    }

}
