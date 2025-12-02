 

package com.auto.mall.config.codec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import org.redisson.client.codec.BaseCodec;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;

import java.io.IOException;

public class FastJsonCodec extends BaseCodec {
  private final Encoder encoder = (in) -> {
    ByteBuf out = ByteBufAllocator.DEFAULT.buffer();

    try {
      ByteBufOutputStream os = new ByteBufOutputStream(out);
      JSON.writeJSONString(os, in, new SerializerFeature[]{SerializerFeature.WriteClassName});
      return os.buffer();
    } catch (IOException var3) {
      IOException ex = var3;
      out.release();
      throw ex;
    } catch (Exception var4) {
      Exception e = var4;
      out.release();
      throw new IOException(e);
    }
  };
  private final Decoder<Object> decoder = (buf, state) -> {
    return JSON.parseObject(new ByteBufInputStream(buf), Object.class, new Feature[0]);
  };

  public FastJsonCodec() {
  }

  public Decoder<Object> getValueDecoder() {
    return this.decoder;
  }

  public Encoder getValueEncoder() {
    return this.encoder;
  }
}
