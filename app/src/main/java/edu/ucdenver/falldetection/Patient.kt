package edu.ucdenver.falldetection

import java.util.*

// import java.util.*

data class Patient (val id: UUID = UUID.randomUUID(),
                    var firstName: String = "",
                    var lastName: String = "",
                    var roomNumber: Int = 1,
                    var age: Int = 80,
                    var sessionHistory: MutableList<Calendar> = mutableListOf()
)