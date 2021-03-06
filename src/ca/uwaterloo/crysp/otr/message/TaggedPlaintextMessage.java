/*
 *  Java OTR library
 *  Copyright (C) 2008-2009  Ian Goldberg, Muhaimeen Ashraf, Andrew Chung,
 *                           Can Tang
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of version 2.1 of the GNU Lesser General
 *  Public License as published by the Free Software Foundation.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ca.uwaterloo.crysp.otr.message;

import ca.uwaterloo.crysp.otr.OTRException;
import ca.uwaterloo.crysp.otr.OutBuf;

/**
 * Represents a tagged plaintext message. Communicates willingness to use OTR.
 * 
 * @author Andrew Chung (kachung@uwaterloo.ca)
 */
public class TaggedPlaintextMessage extends OTRMessage {
  private String contents;

  /**
   * Constructs a tagged plaintext message with the specified contents.
   * 
   * @param contents The entire plaintext message.
   */
  public TaggedPlaintextMessage(String contents) {
    super(MSG_TAGGED_WHITESPACE);
    this.contents = contents;
  }

  /**
   * Returns the contents of the tagged plaintext message.
   * 
   * @return the contents of the tagged plaintext message.
   */
  public byte[] getContent() throws OTRException {
    return contents.getBytes();
  }

  public String getStripped() {
    int end = contents.indexOf(TaggedPlaintextMessage.MSG_TAG_BASE);
    String ret = contents.substring(0, end);
    return ret;
  }

  public void write(OutBuf stream) throws OTRException {
    stream.writeBytes(contents.getBytes());
  }

}
