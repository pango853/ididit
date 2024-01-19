package net.pangos.ididit.model

/**
 * ...
 * checklists:
 *   - name: Wake-Up Tasks
 *     id: 1-wake-up
 * 	   time-start: 05:00:00
 * 	   time-end: 10:00:00
 *     tasks: ...
 *   - name: ...
 *     id: ...
 */
class Checklist(val order: Int=-1, val name: String, val id: String, val timeStart:String, val timeEnd:String, val tasks: List<Task>){
    companion object{
        private var listIdx = 0
        fun createChecklistsList(n: Int): ArrayList<Checklist>{
            val checklists = ArrayList<Checklist>()
            for(i in 1..n){
                checklists.add(Checklist(-1+1+i, "My Checklist $i", "checklist-$i", "05:00:00", "10:00:00", ArrayList<Task>()))
            }
            return checklists
        }
    }
}