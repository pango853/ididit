package net.pangos.ididit.model

/**
 * ...
 * checklists:
 *   - name: ...
 *     tasks:
 *       - name: Prepare your own snacks
 *       - name: Get ready at doorway by 7:15 AM
 *   - name: ...
 *     id: ...
 */
class Task(val order: Int=-1, val name: String, val remark: String?=null){

}