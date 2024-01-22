package com.pcapps.personalwebsite.sections

import androidx.compose.runtime.*
import com.pcapps.personalwebsite.components.SectionTitle
import com.pcapps.personalwebsite.components.SkillBar
import com.pcapps.personalwebsite.models.Section
import com.pcapps.personalwebsite.models.Skill
import com.pcapps.personalwebsite.models.Theme
import com.pcapps.personalwebsite.styles.AboutImageStyle
import com.pcapps.personalwebsite.styles.AboutTextStyle
import com.pcapps.personalwebsite.util.Constants
import com.pcapps.personalwebsite.util.Constants.ABOUT_TEXT
import com.pcapps.personalwebsite.util.Constants.FONT_FAMILY
import com.pcapps.personalwebsite.util.Constants.SECTION_WIDTH
import com.pcapps.personalwebsite.util.ObserveViewPortEntered
import com.pcapps.personalwebsite.util.Res
import com.pcapps.personalwebsite.util.animatePercentage
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection() {
    Box (
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
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
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(
                if(breakpoint >= Breakpoint.MD) 90.percent
                else 100.px
            ),
            numColumns = numColumns(base = 1, md = 2)
        ) {
            if(breakpoint >= Breakpoint.MD) AboutImage()
            AboutMe()
        }

    }
}

@Composable
fun AboutImage() {
    Box(
        modifier = AboutImageStyle.toModifier().fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(80.percent),
            src = Res.Image.about,
            description = "About Image"
        )
    }
}

@Composable
fun AboutMe() {
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember { mutableStateListOf(0, 0, 0, 0, 0) }

    ObserveViewPortEntered(
        sectionId = Section.About.id,
        distanceFromTop = 300.0,
        onViewPortEntered = {
            viewportEntered = true
            Skill.values().forEach { skill ->
                scope.launch{
                    animatePercentage(
                        percent = skill.percentage.value.toInt(),
                        onUpdate = {
                            animatedPercentage[skill.ordinal] = it
                        }
                    )
                }
            }
        }
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        SectionTitle(section = Section.About)
        P(
            attrs = AboutTextStyle.toModifier()
                .margin(topBottom = 25.px)
                .maxWidth(500.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Normal)
                .fontStyle(FontStyle.Italic)
                .color(Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(ABOUT_TEXT)
        }
        Skill.values().forEach { skill ->
            SkillBar(
                name = skill.title,
                index = skill.ordinal,
                percentage = if(viewportEntered) skill.percentage else 0.percent,
                animatedPercentage = if(viewportEntered) animatedPercentage[skill.ordinal] else 0
            )
        }
    }
}