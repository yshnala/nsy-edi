package com.goldtek.edi_serv.repostory.edi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goldtek.edi_serv.entity.edi.FileMetadata;

public interface FileMetadataRepository  extends JpaRepository<FileMetadata,Long>{

	
	
	@Query(nativeQuery = true,
	            value = """
	            		SELECT  f.*  from FileMetadata f 
	            		         	JOIN 
	            		OrderMapping p
	            		ON 
	            		f.isa_control_number = p.isa_control_number
	            		AND f.gs_control_number = p.gs_control_number
	            		AND f.st_control_number = p.st_control_number
	            		WHERE 
	            		         p.po_number = :customerDocno
	            			AND f.file_type = '850';
	            		""" )
	public List<FileMetadata> findFileMetadataByCustomerDocno(@Param("customerDocno") String customerDocno);

	public List<FileMetadata> findFileMetadataByFileTypeOrderByIsaControlNumberDesc(String fileType);

}
