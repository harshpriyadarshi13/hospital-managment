package com.pree.hospitalManagement.dto;

import com.pree.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BloodGroupCountResponceEntity {

    private BloodGroupType bloodGroupType;
    private Long count;

}
