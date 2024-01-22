package com.pcapps.personalwebsite.sections

import androidx.compose.runtime.Composable
import com.pcapps.personalwebsite.components.SectionTitle
import com.pcapps.personalwebsite.components.ServiceCard
import com.pcapps.personalwebsite.models.Section
import com.pcapps.personalwebsite.models.Service
import com.pcapps.personalwebsite.util.Constants
import com.pcapps.personalwebsite.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ServiceSection() {
    Box (
        modifier = Modifier
            .id(Section.Service.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
//    ServiceCard(service = Service.Android)
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            )
            .maxWidth(1200.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 20.px),
            section = Section.Service,
            alignment = Alignment.CenterHorizontally
        )
        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 2, md = 3)
        ) {
            Service.values().forEach { service ->
                ServiceCard(service = service)
            }
        }
    }
}
