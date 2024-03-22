package com.pcapps.personalwebsite.models

import com.pcapps.personalwebsite.util.Constants.LOREM_IPSUM_SHORTEST
import com.pcapps.personalwebsite.util.Res
import org.w3c.dom.Image

enum class Testimonial (
    val image: String,
    val fullName: String,
    val profession: String,
    val review: String
) {
    First(
        image = Res.Image.avatar1,
        fullName = "Milica Ilic",
        profession = "Web Designer",
        review = LOREM_IPSUM_SHORTEST
    ),
    Second(
        image = Res.Image.avatar2,
        fullName = "Stefan Jovanovic",
        profession = "Android Developer",
        review = LOREM_IPSUM_SHORTEST
    ),
    Third(
        image = Res.Image.avatar3,
        fullName = "Ana Milic",
        profession = "Business Analyst",
        review = LOREM_IPSUM_SHORTEST
    ),
    Fourth(
        image = Res.Image.avatar4,
        fullName = "Darko Pesic",
        profession = "Top Manager",
        review = LOREM_IPSUM_SHORTEST
    ),
    Fifth(
        image = Res.Image.avatar5,
        fullName = "Milena Nesovic",
        profession = "HR Recruiter",
        review = LOREM_IPSUM_SHORTEST
    ),
    Sixth(
        image = Res.Image.avatar6,
        fullName = "Aca Rodic",
        profession = "Cyber Security Analyst",
        review = LOREM_IPSUM_SHORTEST
    )
}