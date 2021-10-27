package com.example.demolivescore.dto;

import com.example.demolivescore.model.Country;
import com.example.demolivescore.model.Federation;

import java.util.List;

import lombok.Data;

@Data
public class ResultDto {
    private boolean success;
    private List<Federation> data;
}
