package com.pcapps.personalwebsite.components

import androidx.compose.runtime.Composable
import com.pcapps.personalwebsite.models.Section
import com.pcapps.personalwebsite.models.Theme
import com.pcapps.personalwebsite.util.Constants.FONT_FAMILY
import com.pcapps.personalwebsite.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth(80.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide()
        RightSide()
    }
}

@Composable
fun LeftSide() {
    Row {
        Image(
            src = Res.Image.logo,
            description = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(6).forEach {section ->
            Link(
                modifier = Modifier
                    .padding(right = 30.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal),
                path = section.path,
                text = section.title
            )
        }
    }
}