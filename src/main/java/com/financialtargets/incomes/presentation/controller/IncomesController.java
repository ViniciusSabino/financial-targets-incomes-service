package com.financialtargets.incomes.presentation.controller;

import com.financialtargets.incomes.application.dto.IncomeCreateDTO;
import com.financialtargets.incomes.application.dto.IncomeResponseDTO;
import com.financialtargets.incomes.domain.exception.IncomeException;
import com.financialtargets.incomes.presentation.exception.ExceptionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Incomes", description = "Endpoints from Managing Incomes")
public interface IncomesController {

    @Operation(summary = "Create a Income",
            description = "Create a Income",
            tags = {"Incomes"},
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = IncomeResponseDTO.class)
                            )
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    })
            }
    )
    ResponseEntity<IncomeResponseDTO> create(IncomeCreateDTO incomeCreateDTO) throws IncomeException;

    @Operation(summary = "Delete a Income",
            description = "Delete a Income",
            tags = {"Incomes"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    })
            }
    )
    ResponseEntity<Void> delete(String id);

    @Operation(summary = "List Incomes by month and year parameter",
            description = "List Incomes by month and year parameter",
            tags = {"Incomes"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = IncomeResponseDTO.class))
                            )
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    }),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ExceptionResponse.class)
                            )
                    })
            }
    )
    ResponseEntity<List<IncomeResponseDTO>> listByMonth(String month, String year) throws Exception;
}
