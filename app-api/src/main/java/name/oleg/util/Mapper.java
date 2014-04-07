package name.oleg.util;

public interface Mapper<DTO, ENTITY> {

    public ENTITY fromDto(DTO dto);

    public DTO toDto(ENTITY entity);
}
