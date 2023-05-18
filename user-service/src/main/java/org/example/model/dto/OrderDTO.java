package org.example.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.example.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class OrderDTO {

    @Schema(description = "id", example = "1")
    private Long id;

    @Schema(description = "Order requester")
    private Long requester;

    @Schema(description = "Responsible", required = true)
    private Long responsible;

    @Schema(description = "Order status: Approved, In progress, Received, Pending approval, Rejected", example = "Approved")
    private OrderStatus status;

    @Schema(description = "Supply date", example = "2019-03-25T09:19:41")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime supplyDate;

    @Schema(description = "Creation date", example = "2019-03-25T09:19:41")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;

    @Schema(description = "Attached file as string in base64")
    private String attachedFile;

    @Schema(description = "City and address which were got from endpoint", example = "Minsk, Pobediteley Avenue 7A")
    private String address;

    @Schema(description = "Count of items", example = "0")
    private Integer itemsCount;
}