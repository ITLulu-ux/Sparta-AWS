package spartaaws.spartaaws.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spartaaws.spartaaws.exception.CustomException;
import spartaaws.spartaaws.exception.ErrorCode;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponseDto createMember(MemberRequestDto requestDto) {

        MemberEntity member = new MemberEntity(
                requestDto.getName(),
                requestDto.getAge(),
                requestDto.getMbti()
        );

        MemberEntity savedMember = memberRepository.save(member);

        return new MemberResponseDto(savedMember);
    }

    public MemberResponseDto getMember(Long id) {

        MemberEntity member = memberRepository.findById(id)
                .orElseThrow(() ->
                        new CustomException(ErrorCode.MEMBER_NOT_FOUND));

        return new MemberResponseDto(member);
    }
}
