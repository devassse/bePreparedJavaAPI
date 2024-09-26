package mz.co.keomagroup.bePreparedJavaAPI.exception;

public class EntityNotFoundException extends BadRequestException{

    public EntityNotFoundException(String message){
        super(message);
    }

}
