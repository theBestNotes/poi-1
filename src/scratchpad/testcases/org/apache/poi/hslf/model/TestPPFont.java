/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hslf.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.junit.Test;


/**
 * Test adding fonts to the presenataion resources
 */
public final class TestPPFont {

    @Test
    public void testCreate() throws IOException {
        HSLFSlideShow ppt = new HSLFSlideShow();
        assertEquals(1, ppt.getNumberOfFonts());
        assertEquals("Arial", ppt.getFont(0).getFontName());

        //adding the same font twice
        assertEquals(0, ppt.addFont(PPFont.ARIAL));
        assertEquals(1, ppt.getNumberOfFonts());

        assertEquals(1, ppt.addFont(PPFont.TIMES_NEW_ROMAN));
        assertEquals(2, ppt.addFont(PPFont.COURIER_NEW));
        assertEquals(3, ppt.addFont(PPFont.WINGDINGS));

        assertEquals(4, ppt.getNumberOfFonts());

        assertEquals(PPFont.TIMES_NEW_ROMAN.getFontName(), ppt.getFont(1).getFontName());
        assertEquals(PPFont.COURIER_NEW.getFontName(), ppt.getFont(2).getFontName());

        PPFont font3 = ppt.getFont(3);
        assertEquals(PPFont.WINGDINGS.getFontName(), font3.getFontName());
        assertEquals(PPFont.SYMBOL_CHARSET, font3.getCharSet());
        assertEquals(PPFont.VARIABLE_PITCH, font3.getPitchAndFamily());
        
        ppt.close();
    }
}
