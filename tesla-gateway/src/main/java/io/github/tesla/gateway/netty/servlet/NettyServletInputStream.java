/*
 * Copyright 2014-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.tesla.gateway.netty.servlet;

import java.io.IOException;

import javax.servlet.ServletInputStream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.handler.codec.http.HttpContent;


public class NettyServletInputStream extends ServletInputStream {

  private final ByteBufInputStream in;
  private final ByteBuf byteBuf;

  public NettyServletInputStream(HttpContent httpContent) {
    this.byteBuf = httpContent.content();
    this.in = new ByteBufInputStream(byteBuf);
  }

  @Override
  public int read() throws IOException {
    return this.in.read();
  }

  @Override
  public int read(byte[] buf) throws IOException {
    return this.in.read(buf);
  }

  @Override
  public int read(byte[] buf, int offset, int len) throws IOException {
    return this.in.read(buf, offset, len);
  }

  public void close() throws IOException {
    // we need to release the ByteBufInputStream
    byteBuf.release();
  }

}
