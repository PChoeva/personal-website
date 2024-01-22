package com.pcapps.personalwebsite.sections

import androidx.compose.runtime.Composable
import com.pcapps.personalwebsite.components.PortfolioCard
import com.pcapps.personalwebsite.components.SectionTitle
import com.pcapps.personalwebsite.models.Portfolio
import com.pcapps.personalwebsite.models.Section
import com.pcapps.personalwebsite.util.Constants
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun PortfolioSection() {
    Box (
        modifier = Modifier
            .id(Section.Portfolio.id)
            .maxWidth(Constants.SECTION_WIDTH.px)
            .padding(topBottom = 100.px),
        contentAlignment = Alignment.Center
    ) {
        PortfolioContent()
    }
}

@Composable
fun PortfolioContent() {
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
                .margin(bottom = 25.px),
            section = Section.Portfolio
        )

        PortfolioCards(breakpoint = breakpoint)
    }
}


@Composable
fun PortfolioCards(breakpoint: Breakpoint) {
    Row(
      modifier = Modifier
          .fillMaxWidth()
          .maxWidth(
              if (breakpoint > Breakpoint.MD) 950.px
              else if (breakpoint > Breakpoint.SM) 625.px
              else 300.px
          )
          .overflow(Overflow.Hidden)
          .scrollBehavior(ScrollBehavior.Smooth)
    ) {
        Portfolio.values().forEach { portfolio ->
            PortfolioCard(
                modifier = Modifier.margin(right = 50.px),
                portfolio = portfolio
            )
//            PortfolioCard(
//                modifier = Modifier.margin(
//                    right = if (portfolio != Portfolio.Five) 25.px else 0.px
//                ),
//                portfolio = portfolio
//            )
        }
    }
}