package com.jxls.writer.command

import spock.lang.Specification
import com.jxls.writer.AreaRef
import com.jxls.writer.CellRef
import com.jxls.writer.Size

/**
 * @author Leonid Vysochyn
 * Date: 2/13/12 2:30 PM
 */
class CommandDataTest extends Specification{
    def "test create with area ref instance"(){
        def command = Mock(Command);
        when:
            def commandData = new CommandData(new AreaRef(new CellRef("sheet1!A1"), new CellRef("sheet1!C4")), command)
        then:
            commandData.getStartCellRef() == new CellRef("sheet1!A1")
            commandData.getSize() == new Size(3, 4)
            commandData.getCommand() == command
    }

    def "test create with area ref"(){
        def command = Mock(Command);
        when:
            def commandData = new CommandData("sheet1!A1:C4", command)
        then:
            commandData.getStartCellRef() == new CellRef("sheet1!A1")
            commandData.getSize() == new Size(3, 4)
            commandData.getCommand() == command
    }
    
    def "test create with cell ref and size"(){
        def command = Mock(Command)
        when:
            def commandData = new CommandData(new CellRef("sheet1", 0, 0), new Size(3,4), command)
        then:
            commandData.getStartCellRef() == new CellRef("sheet1!A1")
            commandData.getSize() == new Size(3,4)
    }
}
