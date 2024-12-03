package com.example.hostelworldchallenge.feature_property_listing.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.hostelworldchallenge.R
import com.example.hostelworldchallenge.feature_property_listing.data.model.property.FacilityX

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExpandableFacilitiesGrid(facilities: List<FacilityX>) {
    var expanded by remember { mutableStateOf(false) }
    val displayedFacilities = if (expanded) facilities else facilities.take(6)

    Column {
        FlowRow(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            displayedFacilities.forEach {
                FacilityItem(facilityX = it)
            }
        }

        if (facilities.size > 6) {
            TextButton(
                onClick = { expanded = !expanded },
                modifier = Modifier
                    .align(Alignment.Start)
            ) {
                Text(
                    if (expanded) stringResource(id = R.string.property_expandable_text_less) else stringResource(
                        id = R.string.property_expandable_text_more
                    )
                )
            }
        }
    }
}