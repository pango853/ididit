package net.pangos.ididit.static

import net.pangos.ididit.model.Checklist
import net.pangos.ididit.model.File
import net.pangos.ididit.model.Task

object ChecklistSamples {
    @JvmStatic
    fun generate() : File{

        val checklists = ArrayList<Checklist>()

        run{
            checklists.add(Checklist(id="Wake-Up Tasks", name="1-wake-up", timeStart="05:00:00", timeEnd="10:00:00",
                tasks = mutableListOf(
                    Task(name="Prepare your own snacks"),
                    Task(name="Get ready at doorway", remark="by 7:15 AM")
                )
            ))
        }
        run{
            val tasks = ArrayList<Task>()
            tasks.add(Task(name="Arrival at MRT"))
            tasks.add(Task(name="Arrival on bus"))
            tasks.add(Task(name="Arrival at school"))
            checklists.add(Checklist(id="School Commuting Tasks", name="2-school-commuting", timeStart="07:00:00", timeEnd="09:00:00", tasks=tasks))
        }
        run{
            checklists.add(Checklist(id="After-School Tasks", name="3-after-school", timeStart="15:00:00", timeEnd="19:00:00",
                tasks = mutableListOf(
                    Task(name="Fold dried clothes"),
                    Task(name="One plus exercise", remark="to ensure your are healthy everyday")
                )
            ))
        }
        run{
            checklists.add(Checklist(id="Bedtime Routines", name="4-bedtime", timeStart="19:00:00", timeEnd="22:00:00",
                tasks = mutableListOf(
                    Task(name="Clean up toys")
                )
            ))
        }

        return File(id=1, publishedDate = "23/1/2024", version="1.0.0", checklists=checklists)
    }
}