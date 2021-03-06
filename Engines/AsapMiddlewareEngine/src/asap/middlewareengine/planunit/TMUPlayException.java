/*******************************************************************************
 * Copyright (C) 2009 Human Media Interaction, University of Twente, the Netherlands
 * 
 * This file is part of the Elckerlyc BML realizer.
 * 
 * Elckerlyc is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Elckerlyc is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Elckerlyc.  If not, see http://www.gnu.org/licenses/.
 ******************************************************************************/
package asap.middlewareengine.planunit;

import asap.realizer.planunit.TimedPlanUnitPlayException;

/**
 * Thrown when playback of a TMU fails
 * @author Dennis
 *
 */
public class TMUPlayException extends TimedPlanUnitPlayException
{
    public TimedMiddlewareUnit timedMU;
    public TMUPlayException(String str, TimedMiddlewareUnit tru)
    {
        super(str,tru);
        timedMU = tru;        
    }
    
    private static final long serialVersionUID = -69835633453209435L;
}
