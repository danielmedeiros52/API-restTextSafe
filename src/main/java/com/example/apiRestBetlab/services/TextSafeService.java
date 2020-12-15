package com.example.apiRestBetlab.services;



import com.example.apiRestBetlab.dto.TextSafeDTO;
import com.example.apiRestBetlab.model.TextSafe;
import com.example.apiRestBetlab.repository.TextSafeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class TextSafeService {

  // TODO: 14/12/2020  O Autowired deve ser usando no construcctor  e todas as variaveis devem ser delcaradas como final

  private final TextSafeDao dao;


  // TODO: 14/12/2020 isto poderia ser feito em uma linha so
  @Transactional(readOnly = true)
  public Page<TextSafe> listAllPages(Pageable pageable) {

    return dao.findAll(pageable);
  }



  public TextSafeDTO insert(TextSafe entity) {

    return convertToDto(dao.save(entity));

  }

  public  TextSafeDTO convertToDto(TextSafe entity){
    TextSafeDTO objectTextSafeDTO = new TextSafeDTO();
    objectTextSafeDTO.setDescription(entity.getDescription());
    objectTextSafeDTO.setId(entity.getId());
    return objectTextSafeDTO;
  }

}
