import type {
  Double,
  Int32,
  DirectEventHandler,
} from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps, ColorValue } from 'react-native';

/* Type should be redeclared because of codegen ts parser doesn't allow imported type
 * [comments](https://github.com/reactwg/react-native-new-architecture/discussions/91#discussioncomment-4282452)
 */

interface BaseOverlay {
  position: { latitude: Double; longitude: Double };
  zIndexValue: Int32;
  isHidden: boolean;
  minZoom: Double;
  maxZoom: Double;
  isMinZoomInclusive: boolean;
  isMaxZoomInclusive: boolean;
}

////////////////////

interface Props extends BaseOverlay, ViewProps {
  onTapOverlay?: DirectEventHandler<Readonly<{}>>;
  width?: Double;
  height?: Double;
  anchor?: Readonly<{ x: Double; y: Double }>;
  angle?: Double;
  isFlatEnabled?: boolean;
  isIconPerspectiveEnabled?: boolean;
  alpha?: Double;
  isHideCollidedSymbols?: boolean;
  isHideCollidedMarkers?: boolean;
  isHideCollidedCaptions?: boolean;
  isForceShowIcon?: boolean;
  tintColor?: ColorValue;
  image?: string;
}

export default codegenNativeComponent<Props>('RNCNaverMapMarker');
